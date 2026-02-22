package team.neoradiance.immersiveadventuring.common.iemetalexpansions.lead;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import team.neoradiance.immersiveadventuring.Lib;
import net.minecraft.world.level.block.Block;

public class LeadTags {
    // This tag will allow us to add these blocks to the incorrect tags that cannot mine them
    public static final TagKey<Block> NEEDS_LEAD_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(Lib.MOD_ID, "needs_lead_tool"));

    // This tag will be passed into our tier
    public static final TagKey<Block> INCORRECT_FOR_LEAD_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(Lib.MOD_ID, "incorrect_for_lead_tool"));
}
