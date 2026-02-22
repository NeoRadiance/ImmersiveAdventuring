package team.neoradiance.immersiveadventuring.common.nylon;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.neoradiance.immersiveadventuring.Lib;
import team.neoradiance.immersiveadventuring.common.nylon.items.NylonIngotItem;
import team.neoradiance.immersiveadventuring.common.nylon.items.NylonPlateItem;

import java.util.concurrent.CompletableFuture;

public class NylonItemTagsProvider extends ItemTagsProvider {
    // Get parameters from GatherDataEvent.
    public NylonItemTagsProvider(
            PackOutput pOutput,
            CompletableFuture<HolderLookup.Provider> pLookupProvider,
            CompletableFuture<TagLookup<Block>> blocks,
            ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, blocks, Lib.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // 创建尼龙锭标签
        tag(net.minecraft.tags.ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/nylon")))
                .add(NylonIngotItem.NYLON_INGOT_ITEM.get());

        // 创建尼龙板标签
        tag(net.minecraft.tags.ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "plates/nylon")))
                .add(NylonPlateItem.NYLON_PLATE_ITEM.get());
    }
}
