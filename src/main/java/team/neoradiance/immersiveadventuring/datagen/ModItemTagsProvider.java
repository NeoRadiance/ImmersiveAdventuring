package team.neoradiance.immersiveadventuring.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.neoradiance.immersiveadventuring.Lib;
import team.neoradiance.immersiveadventuring.common.nylon.NylonItemTags;
import team.neoradiance.immersiveadventuring.common.nylon.items.NylonIngotItem;
import team.neoradiance.immersiveadventuring.common.nylon.items.NylonPlateItem;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider
{
	private final PackOutput pOutput;
	private final CompletableFuture<HolderLookup.Provider> pLookupProvider;
	private final CompletableFuture<TagLookup<Block>> blocks;
	private final ExistingFileHelper existingFileHelper;

	public ModItemTagsProvider(PackOutput pOutput,
							   CompletableFuture<HolderLookup.Provider> pLookupProvider,
							   CompletableFuture<TagLookup<Block>> blocks,
							   ExistingFileHelper existingFileHelper)
	{
		super(pOutput, pLookupProvider, blocks, Lib.MOD_ID, existingFileHelper);
		this.pOutput = pOutput;
		this.pLookupProvider = pLookupProvider;
		this.blocks = blocks;
		this.existingFileHelper = existingFileHelper;
	}

	@Override
	protected void addTags(Provider provider)
	{
		tag(NylonItemTags.NYLON_INGOTS).add(NylonIngotItem.NYLON_INGOT_ITEM.get());
		tag(NylonItemTags.NYLON_PLATES).add(NylonPlateItem.NYLON_PLATE_ITEM.get());
	}
}
