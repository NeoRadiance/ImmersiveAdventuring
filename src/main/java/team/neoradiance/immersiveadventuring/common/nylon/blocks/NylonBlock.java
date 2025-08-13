package team.neoradiance.immersiveadventuring.common.nylon.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static team.neoradiance.immersiveadventuring.Register.BLOCKS;
import static team.neoradiance.immersiveadventuring.Register.ITEMS;

public class NylonBlock {
    public static void load(){
        team.neoradiance.immersiveadventuring.ImmersiveAdventuring.LOGGER.info("Loading NylonBlock");
    }
    // Creates a new Block with the id "immersiveadventuring:nylon_block", combining the namespace and path
    public static final DeferredBlock<Block> NYLON_BLOCK = BLOCKS.register(
        "nylon_block", 
        () -> new Block(BlockBehaviour.Properties.of()
                .destroyTime(2.0f)
                .explosionResistance(10.0f)
                .sound(SoundType.STONE)
                .lightLevel(state -> 0)
        ));
    // Creates a new BlockItem with the id "immersiveadventuring:nylon_block", combining the namespace and path
    public static final DeferredItem<BlockItem> NYLON_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("nylon_block", NYLON_BLOCK);
}
