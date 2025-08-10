package team.neoradiance.immersiveadventuring.common.examples.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import static team.neoradiance.immersiveadventuring.Register.BLOCKS;
import static team.neoradiance.immersiveadventuring.Register.ITEMS;

public class ExampleBlock {
    public static void load(){
        team.neoradiance.immersiveadventuring.ImmersiveAdventuring.LOGGER.info("Loading ExampleBlock");
    }
    // Creates a new Block with the id "immersiveadventuring:example_block", combining the namespace and path
    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    // Creates a new BlockItem with the id "immersiveadventuring:example_block", combining the namespace and path
    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);
}
