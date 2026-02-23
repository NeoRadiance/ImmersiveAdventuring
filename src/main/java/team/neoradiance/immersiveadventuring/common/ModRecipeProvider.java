package team.neoradiance.immersiveadventuring.common;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;
import team.neoradiance.immersiveadventuring.common.nylon.NylonRecipes;
import team.neoradiance.immersiveadventuring.common.iemetalexpansions.lead.LeadRecipes;
import team.neoradiance.immersiveadventuring.common.iemetalexpansions.aluminum.AluminumRecipes;

import java.util.concurrent.CompletableFuture;

/**
 * Mod Recipe Provider
 * <p>
 * This class serves as the root recipe provider for the mod, following the IE pattern.
 * It delegates recipe generation to specialized modules for different material types.
 * <p>
 * Subsequent classes implement their own recipe generation logic by extending this class. Since RecipeProvider returns are unique, to prevent
 * the "Duplicate provider: Recipes" error, there can only be one root Provider. And because other Providers need to
 * access the protected has() method, they must extend this class.
 */
public class ModRecipeProvider extends RecipeProvider {
    private final PackOutput packOutput;
    private final CompletableFuture<HolderLookup.Provider> lookupProvider;

    public ModRecipeProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pPackOutput, lookupProvider);
        this.packOutput = pPackOutput;
        this.lookupProvider = lookupProvider;
    }


    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        // Generate recipes for different materials
        new NylonRecipes(this.packOutput, this.lookupProvider).buildRecipes(pRecipeOutput);
        new LeadRecipes(this.packOutput, this.lookupProvider).buildRecipes(pRecipeOutput);
        new AluminumRecipes(this.packOutput, this.lookupProvider).buildRecipes(pRecipeOutput);
    }
}