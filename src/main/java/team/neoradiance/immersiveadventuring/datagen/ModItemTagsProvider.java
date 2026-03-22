package team.neoradiance.immersiveadventuring.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.neoradiance.immersiveadventuring.Lib;
import team.neoradiance.immersiveadventuring.utilities.TagWrapper;

import java.util.concurrent.CompletableFuture;

import static team.neoradiance.immersiveadventuring.common.nylon.NylonItemTags.NYLON_INGOTS;
import static team.neoradiance.immersiveadventuring.common.nylon.NylonItemTags.NYLON_PLATES;

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

	private void addAll(TagWrapper<Item> tagWrapper)
	{
		for(Item item : tagWrapper.list)
		{
			tag(tagWrapper.tag).add(item);
		}
	}

	@Override
	protected void addTags(Provider provider)
	{
		addAll(NYLON_INGOTS);
		addAll(NYLON_PLATES);
	}
}
