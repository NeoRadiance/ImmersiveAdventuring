package team.neoradiance.immersiveadventuring.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import team.neoradiance.immersiveadventuring.Lib;
import team.neoradiance.immersiveadventuring.common.nylon.NylonBlockTags;
import team.neoradiance.immersiveadventuring.common.nylon.blocks.NylonBlock;

import java.util.concurrent.CompletableFuture;

/**
 * Mod Block Tags Provider
 * <p>
 * This class is responsible for generating all block tags for the mod.
 * It extends {@link BlockTagsProvider} and implements the {@link #addTags(HolderLookup.Provider)} method
 * to define custom block tags.
 * </p>
 *
 * <h2>Original Problem</h2>
 * <p>
 * Initially, the tag generation followed a modular inheritance pattern similar to the recipe system:
 * </p>
 * <ul>
 *   <li>{@code NylonBlockTags} extended {@code ModBlockTagsProvider}</li>
 *   <li>{@code ModBlockTagsProvider.addTags()} created a new {@code NylonBlockTags} instance and called its {@code addTags()} method</li>
 *   <li>Inside {@code NylonBlockTags.addTags()}, the {@code tag()} method was called on the new instance</li>
 * </ul>
 * <p>
 * However, this approach resulted in tags only generating empty directory structures without any actual JSON files.
 * The recipe generation worked correctly, but tag generation failed.
 * </p>
 *
 * <h3>Root Cause Analysis</h3>
 * <p>
 * The issue stemmed from how NeoForge's data generation framework handles tag providers:
 * </p>
 * <ol>
 *   <li><strong>Provider Registration</strong>: Only the root provider ({@code ModBlockTagsProvider}) is registered
 *       with the data generator via {@code generator.addProvider()}. The framework tracks this specific instance
 *       and collects tag data from it.</li>
 *   <li><strong>Isolated Instance Problem</strong>: When {@code ModBlockTagsProvider.addTags()} created a new
 *       {@code NylonBlockTags} instance and called {@code tag()} on it, that new instance was <em>not</em>
 *       registered with the data generator. Its internal tag data structures were never collected or written
 *       to output files.</li>
 *   <li><strong>Protected Method Access</strong>: The {@code tag()} method in {@code BlockTagsProvider} is
 *       {@code protected}, meaning it can only be called on the current instance ({@code this}) or from a
 *       subclass. Calling it on a separate, unregistered instance means the tag data goes nowhere.</li>
 * </ol>
 * <p>
 * In contrast, recipe generation works differently: the {@code RecipeOutput} parameter passed to
 * {@code buildRecipes()} is a functional interface that directly writes to the data generator's output stream,
 * regardless of which object instance calls it. This is why the modular pattern worked for recipes but not for tags.
 * </p>
 *
 * <h2>Solution</h2>
 * <p>
 * The fix involves two key changes:
 * </p>
 * <ol>
 *   <li><strong>Tag Key Constants</strong>: {@code NylonBlockTags} was refactored into a static constant class
 *       that only defines {@code TagKey<Block>} constants, without extending any provider class.</li>
 *   <li><strong>Direct Tag Registration</strong>: The {@code addTags()} method in this class now calls
 *       {@code tag()} directly on {@code this} (the current instance), using the tag keys defined in
 *       {@code NylonBlockTags}. This ensures the tag data is registered with the correct provider instance
 *       that the data generator is tracking.</li>
 * </ol>
 *
 * <h3>Code Comparison</h3>
 * <p>
 * <strong>Before (Broken):</strong>
 * </p>
 * <pre>{@code
 * // NylonBlockTags extended ModBlockTagsProvider
 * public class NylonBlockTags extends ModBlockTagsProvider {
 *     @Override
 *     public void addTags(HolderLookup.Provider provider) {
 *         tag(BlockTags.create(...)).add(...); // Called on unregistered instance
 *     }
 * }
 *
 * // ModBlockTagsProvider created new instance
 * public class ModBlockTagsProvider extends BlockTagsProvider {
 *     @Override
 *     protected void addTags(HolderLookup.Provider provider) {
 *         new NylonBlockTags(...).addTags(provider); // New instance not tracked
 *     }
 * }
 * }</pre>
 *
 * <p>
 * <strong>After (Fixed):</strong>
 * </p>
 * <pre>{@code
 * // NylonBlockTags is now a static constant holder
 * public class NylonBlockTags {
 *     public static final TagKey<Block> NYLON_BLOCKS = BlockTags.create(...);
 * }
 *
 * // ModBlockTagsProvider calls tag() on itself
 * public class ModBlockTagsProvider extends BlockTagsProvider {
 *     @Override
 *     protected void addTags(HolderLookup.Provider provider) {
 *         tag(NylonBlockTags.NYLON_BLOCKS).add(...); // Called on 'this' - the registered instance
 *     }
 * }
 * }</pre>
 *
 * <h2>Key Takeaway</h2>
 * <p>
 * When working with NeoForge's tag generation system, always call {@code tag()} on the provider instance
 * that was registered with the data generator. Creating separate provider instances and calling methods on
 * them will result in tag data being lost, as those instances are not tracked by the framework.
 * </p>
 *
 * @see ModItemTagsProvider for the corresponding item tags provider
 * @see NylonBlockTags for the tag key definitions
 */
public class ModBlockTagsProvider extends BlockTagsProvider
{
	private final PackOutput pPackOutput;
	private final CompletableFuture<HolderLookup.Provider> plookupProvider;
	private final ExistingFileHelper existingFileHelper;

	public ModBlockTagsProvider(
			PackOutput pOutput,
			CompletableFuture<Provider> pLookupProvider,
			ExistingFileHelper existingFileHelper)
	{

		super(pOutput, pLookupProvider, Lib.MOD_ID, existingFileHelper);
		this.pPackOutput = pOutput;
		this.plookupProvider = pLookupProvider;
		this.existingFileHelper = existingFileHelper;
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider provider)
	{
		tag(NylonBlockTags.NYLON_BLOCKS).add(NylonBlock.NYLON_BLOCK.get());
	}
}
