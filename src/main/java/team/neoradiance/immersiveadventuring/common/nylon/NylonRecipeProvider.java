package team.neoradiance.immersiveadventuring.common.nylon;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;

import org.jetbrains.annotations.NotNull;
import team.neoradiance.immersiveadventuring.common.nylon.blocks.NylonBlock;
import team.neoradiance.immersiveadventuring.common.nylon.items.NylonIngotItem;
import team.neoradiance.immersiveadventuring.common.nylon.items.NylonNuggetItem;

import java.util.concurrent.CompletableFuture;

/**
 * Vanilla Crafting Recipe Provider
 * <p>
 * This class generates vanilla Minecraft crafting recipes for nylon items.
 * It handles the basic crafting recipes like ingot to block, nugget to ingot, etc.
 * <p>
 * Note: Part of recipes for Immersive Engineering Metal Press have no need to be
 * written.IE will load them recording to vanilla recipes. But others ,not simply
 * packing or unpacking ,and for other multiblock structures ,are need to do some
 * extra work.
 * <p>
 * IE recipe location: src/generated/resources/data/immersiveadventuring/recipe/IErecipe/nylon
 */
public class NylonRecipeProvider extends RecipeProvider {
    //https://docs.neoforged.net/docs/datagen/server/recipes
    public NylonRecipeProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pPackOutput, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        // 无序合成
        // 4*ingot -> 1*block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NylonBlock.NYLON_BLOCK_ITEM.get())
                .requires(NylonIngotItem.NYLON_INGOT_ITEM, 4)
                .unlockedBy("has_nylon_ingot", has(NylonIngotItem.NYLON_INGOT_ITEM))
                .save(pRecipeOutput);
        // 4*nugget -> 1*ingot
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NylonIngotItem.NYLON_INGOT_ITEM.get())
                .requires(NylonNuggetItem.NYLON_NUGGET_ITEM.get(), 4)
                .unlockedBy("has_nylon_nugget", has(NylonNuggetItem.NYLON_NUGGET_ITEM.get()))
                .save(pRecipeOutput, "nylon_ingot_from_nuggets");
        // 1*ingot -> 4*nugget
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NylonNuggetItem.NYLON_NUGGET_ITEM.get(), 4)
                .requires(NylonIngotItem.NYLON_INGOT_ITEM.get(), 1)
                .unlockedBy("has_nylon_ingot", has(NylonIngotItem.NYLON_INGOT_ITEM.get()))
                .save(pRecipeOutput);
        // 1*block -> 4*ingot
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NylonIngotItem.NYLON_INGOT_ITEM.get(), 4)
                .requires(NylonBlock.NYLON_BLOCK_ITEM.get(), 1)
                .unlockedBy("has_nylon_block", has(NylonBlock.NYLON_BLOCK_ITEM.get()))
                .save(pRecipeOutput, "nylon_ingot_from_block");
    }
}