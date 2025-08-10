package team.neoradiance.immersiveadventuring.common.examples;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;

import team.neoradiance.immersiveadventuring.Register;
import team.neoradiance.immersiveadventuring.common.examples.items.*;
import team.neoradiance.immersiveadventuring.common.examples.blocks.*;

public class ExampleTab {

    // Creates a creative tab with the id "immersiveadventuring:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = Register.CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.immersiveadventuring")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ExampleItem.EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ExampleItem.EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());
    public static void load(){
        ExampleBlock.load();
        ExampleItem.load();
        // Log the loading of the example tab
        team.neoradiance.immersiveadventuring.ImmersiveAdventuring.LOGGER.info("Loading ExampleTab");
    }
}
