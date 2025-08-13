package team.neoradiance.immersiveadventuring;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;

import team.neoradiance.immersiveadventuring.common.nylon.items.*;
import team.neoradiance.immersiveadventuring.common.nylon.blocks.*;

public class ModRecipeProvider extends RecipeProvider {
    //https://docs.neoforged.net/docs/datagen/server/recipes
    public ModRecipeProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pPackOutput, lookupProvider);
    }
    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        // 无序合成
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,NylonBlock.NYLON_BLOCK_ITEM.get())
                .requires(NylonIngotItem.NYLON_INGOT_ITEM,9)
                .unlockedBy("has_nylon_ingot",has(NylonIngotItem.NYLON_INGOT_ITEM))
                .save(pRecipeOutput);
    }
}
