package team.neoradiance.immersiveadventuring.common.nylon;

import net.minecraft.world.level.block.Block;
import team.neoradiance.immersiveadventuring.common.nylon.blocks.NylonBlock;
import team.neoradiance.immersiveadventuring.utilities.TagWrapper;

/**
 * Nylon Block Tags Definitions
 * <p>
 * This class defines all block tags for nylon-related content.
 * Use these tags in ModBlockTagsProvider to register actual tag data.
 */
public class NylonBlockTags
{
	public static final TagWrapper<Block> NYLON_BLOCKS = new TagWrapper<>(Block.class, "c", "blocks/nylon");

	static
	{
		NYLON_BLOCKS.add(NylonBlock.NYLON_BLOCK.get());
	}

}
