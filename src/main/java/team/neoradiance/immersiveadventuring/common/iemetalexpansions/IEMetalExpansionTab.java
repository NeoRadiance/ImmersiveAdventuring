package team.neoradiance.immersiveadventuring.common.iemetalexpansions;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;

import team.neoradiance.immersiveadventuring.Register;
import team.neoradiance.immersiveadventuring.common.iemetalexpansions.lead.*;

public class IEMetalExpansionTab {

    // Creates a creative tab with the id "immersiveadventuring:nylon_tab" for the nylon item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> IE_METAL_EXPANSION_TAB = Register.CREATIVE_MODE_TABS.register("ie_metal_expansion_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.immersiveadventuring.iemetalexpansions")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> new net.minecraft.world.item.ItemStack(net.minecraft.core.registries.BuiltInRegistries.ITEM.get(net.minecraft.resources.ResourceLocation.fromNamespaceAndPath("immersiveengineering", "ingot_lead"))))
            .displayItems((parameters, output) -> {
                output.accept(LeadTools.LEAD_SWORD.get()); 
            }).build());
    public static void load(){
        LeadTools.load();
        // Log the loading of the IE metal expansion tab
        team.neoradiance.immersiveadventuring.ImmersiveAdventuring.LOGGER.info("Loading IEMetalExpansionTab");
    }
}
