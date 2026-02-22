package team.neoradiance.immersiveadventuring.common.nylon;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.neoradiance.immersiveadventuring.Lib;
import team.neoradiance.immersiveadventuring.common.nylon.blocks.NylonBlock;

import java.util.concurrent.CompletableFuture;

public class NylonBlockTagsProvider extends BlockTagsProvider {
    public NylonBlockTagsProvider(
            PackOutput pOutput,
            CompletableFuture<HolderLookup.Provider> pLookupProvider,
            ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, Lib.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(net.minecraft.tags.BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "blocks/nylon")))
                .add(NylonBlock.NYLON_BLOCK.get());
    }
}
