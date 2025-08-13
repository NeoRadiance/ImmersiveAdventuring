package team.neoradiance.immersiveadventuring.common.nylon.items;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import static team.neoradiance.immersiveadventuring.Register.ITEMS;
public class NylonIngotItem {

    public static final DeferredItem<Item> NYLON_INGOT_ITEM = ITEMS.registerSimpleItem("nylon_ingot", new Item.Properties());
    public static void load() {
        team.neoradiance.immersiveadventuring.ImmersiveAdventuring.LOGGER.info("Loading NylonIngotItem");
    }
}
