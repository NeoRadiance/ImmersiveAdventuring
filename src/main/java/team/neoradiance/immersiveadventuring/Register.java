package team.neoradiance.immersiveadventuring;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Register {
    // Create a Deferred Register to hold Blocks which will all be registered under the "immersiveadventuring" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Lib.MOD_ID);
    // Create a Deferred Register to hold Items which will all be registered under the "immersiveadventuring" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Lib.MOD_ID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "immersiveadventuring" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Lib.MOD_ID);

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, Lib.MOD_ID);
}
