package team.neoradiance.immersiveadventuring.common.nylon;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

/**
 * Nylon Block Tags Definitions
 * <p>
 * This class defines all block tags for nylon-related content.
 * Use these tags in ModBlockTagsProvider to register actual tag data.
 */
public class NylonBlockTags
{
	public static final TagKey<Block> NYLON_BLOCKS = BlockTags.create(
			ResourceLocation.fromNamespaceAndPath("c", "blocks/nylon"));
}
