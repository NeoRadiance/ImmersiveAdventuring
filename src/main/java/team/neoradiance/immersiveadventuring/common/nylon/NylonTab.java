package team.neoradiance.immersiveadventuring.common.nylon;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;

import team.neoradiance.immersiveadventuring.Register;
import team.neoradiance.immersiveadventuring.common.nylon.items.*;
import team.neoradiance.immersiveadventuring.common.nylon.blocks.*;

public class NylonTab {

    // Creates a creative tab with the id "immersiveadventuring:nylon_tab" for the nylon item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> NYLON_TAB = Register.CREATIVE_MODE_TABS.register("nylon_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.immersiveadventuring.nylon")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> NylonIngotItem.NYLON_INGOT_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(NylonNuggetItem.NYLON_NUGGET_ITEM.get()); // Add the nylon item to the tab. For your own tabs, this method is preferred over the event
                output.accept(NylonIngotItem.NYLON_INGOT_ITEM.get());
                output.accept(NylonBlock.NYLON_BLOCK_ITEM.get());
            }).build());
    public static void load(){
        NylonBlock.load();
        NylonIngotItem.load();
        NylonNuggetItem.load();
        // Log the loading of the nylon tab
        team.neoradiance.immersiveadventuring.ImmersiveAdventuring.LOGGER.info("Loading NylonTab");
    }
}
