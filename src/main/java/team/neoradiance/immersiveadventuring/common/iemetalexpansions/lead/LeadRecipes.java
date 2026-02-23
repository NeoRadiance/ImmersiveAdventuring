package team.neoradiance.immersiveadventuring.common.iemetalexpansions.lead;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static blusunrize.immersiveengineering.api.IETags.getIngot;
import static blusunrize.immersiveengineering.api.utils.TagUtils.createItemWrapper;

public class LeadRecipes extends RecipeProvider {
    public LeadRecipes(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pPackOutput, lookupProvider);
    }

    @Override
    public void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        // We use a builder pattern, therefore no variable is created. Create a new builder by calling
        // ShapedRecipeBuilder#shaped with the recipe category (found in the RecipeCategory enum)
        // and a result item, a result item and count, or a result item stack.
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LeadTools.LEAD_PICKAXE.get())
                // Create the lines of your pattern. Each call to #pattern adds a new line.
                // Patterns will be validated, i.e. their shape will be checked.
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                // Create the keys for the pattern. All non-space characters used in the pattern must be defined.
                // This can either accept Ingredients, TagKey<Item>s or ItemLikes, i.e. items or blocks.
                .define('X', createItemWrapper(getIngot("lead")))
                .define('#', Items.STICK)
                // Creates the recipe advancement. While not mandated by the consuming background systems,
                // the recipe builder will crash if you omit this. The first parameter is the advancement name,
                // and the second one is the condition. Normally, you want to use the has() shortcut for the condition.
                // Multiple advancement requirements can be added by calling #unlockedBy multiple times.
                .unlockedBy("has_lead_ingot", has(createItemWrapper(getIngot("lead"))))
                // Stores the recipe in the passed RecipeOutput, to be written to disk.
                // If you want to add conditions to the recipe, those can be set on the output.
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LeadTools.LEAD_SHOVEL.get())
                .pattern(" X ")
                .pattern(" # ")
                .pattern(" # ")
                .define('X', createItemWrapper(getIngot("lead")))
                .define('#', Items.STICK)
                .unlockedBy("has_lead_ingot", has(createItemWrapper(getIngot("lead"))))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LeadTools.LEAD_AXE.get())
                .pattern("XX ")
                .pattern("X# ")
                .pattern(" # ")
                .define('X', createItemWrapper(getIngot("lead")))
                .define('#', Items.STICK)
                .unlockedBy("has_lead_ingot", has(createItemWrapper(getIngot("lead"))))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LeadTools.LEAD_HOE.get())
                .pattern("XX ")
                .pattern(" # ")
                .pattern(" # ")
                .define('X', createItemWrapper(getIngot("lead")))
                .define('#', Items.STICK)
                .unlockedBy("has_lead_ingot", has(createItemWrapper(getIngot("lead"))))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, LeadTools.LEAD_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" # ")
                .define('X', createItemWrapper(getIngot("lead")))
                .define('#', Items.STICK)
                .unlockedBy("has_lead_ingot", has(createItemWrapper(getIngot("lead"))))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, LeadArmor.LEAD_HELMET.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("   ")
                .define('X', createItemWrapper(getIngot("lead")))
                .unlockedBy("has_lead_ingot", has(createItemWrapper(getIngot("lead"))))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, LeadArmor.LEAD_CHESTPLATE.get())
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .define('X', createItemWrapper(getIngot("lead")))
                .unlockedBy("has_lead_ingot", has(createItemWrapper(getIngot("lead"))))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, LeadArmor.LEAD_LEGGINGS.get())
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .define('X', createItemWrapper(getIngot("lead")))
                .unlockedBy("has_lead_ingot", has(createItemWrapper(getIngot("lead"))))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, LeadArmor.LEAD_BOOTS.get())
                .pattern("X X")
                .pattern("X X")
                .define('X', createItemWrapper(getIngot("lead")))
                .unlockedBy("has_lead_ingot", has(createItemWrapper(getIngot("lead"))))
                .save(pRecipeOutput);
    }
}