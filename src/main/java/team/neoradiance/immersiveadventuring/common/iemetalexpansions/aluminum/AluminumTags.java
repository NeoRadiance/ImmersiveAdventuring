package team.neoradiance.immersiveadventuring.common.iemetalexpansions.aluminum;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import team.neoradiance.immersiveadventuring.Lib;

public class AluminumTags {
    // This tag will allow us to add these blocks to the incorrect tags that cannot mine them
    public static final TagKey<Block> NEEDS_ALUMINUM_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(Lib.MOD_ID, "needs_aluminum_tool"));

    // This tag will be passed into our tier
    public static final TagKey<Block> INCORRECT_FOR_ALUMINUM_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(Lib.MOD_ID, "incorrect_for_aluminum_tool"));
}
