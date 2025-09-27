package team.neoradiance.immersiveadventuring.common.iemetalexpansions.lead;


import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;



import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import static blusunrize.immersiveengineering.api.IETags.getIngot;
import static blusunrize.immersiveengineering.api.utils.TagUtils.createItemWrapper;
import static team.neoradiance.immersiveadventuring.Register.ARMOR_MATERIALS;
import static team.neoradiance.immersiveadventuring.Register.ITEMS;
import team.neoradiance.immersiveadventuring.Lib;

public class LeadArmor {
    // ARMOR_MATERIALS is a DeferredRegister<ArmorMaterial>
    // We place lead somewhere between chainmail and iron.
    public static final Holder<ArmorMaterial> LEAD_ARMOR_MATERIAL =
            ARMOR_MATERIALS.register("lead", () -> new ArmorMaterial(
                    // Determines the defense value of this armor material, depending on what armor piece it is.
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 4);
                    }),
                    // Determines the enchantability of the tier. This represents how good the enchantments on this armor will be.
                    // Gold uses 25, we put lead slightly below that.
                    20,
                    // Determines the sound played when equipping this armor.
                    // This is wrapped with a Holder.
                    SoundEvents.ARMOR_EQUIP_GENERIC,
                    // Determines the repair item for this armor.
                    () -> Ingredient.of(createItemWrapper(getIngot("lead"))),//MPCBexplorer:Use this way!
                    // Determines the texture locations of the armor to apply when rendering
                    // This can also be specified by overriding 'IItemExtension#getArmorTexture' on your item if the armor texture needs to be more dynamic
                    List.of(
                            // Creates a new armor texture that will be located at:
                            // - 'assets/mod_id/textures/models/armor/lead_layer_1.png' for the outer texture
                            // - 'assets/mod_id/textures/models/armor/lead_layer_2.png' for the inner texture (only legs)
                            new ArmorMaterial.Layer(
                                    ResourceLocation.fromNamespaceAndPath(Lib.Modid, "lead")
                            )
                            /*

                            MPCBexplorer: Only be uesd for dyeable armor

                            // Creates a new armor texture that will be rendered on top of the previous at:
                            // - 'assets/mod_id/textures/models/armor/lead_layer_1_overlay.png' for the outer texture
                            // - 'assets/mod_id/textures/models/armor/lead_layer_2_overlay.png' for the inner texture (only legs)
                            // 'true' means that the armor material is dyeable; however, the item must also be added to the 'minecraft:dyeable' tag
                            new ArmorMaterial.Layer(
                                    ResourceLocation.fromNamespaceAndPath(Lib.Modid, "lead"), "_overlay", true
                            )
                            */
                    ),
                    // Returns the toughness value of the armor. The toughness value is an additional value included in
                    // damage calculation, for more information, refer to the Minecraft Wiki's article on armor mechanics:
                    // https://minecraft.wiki/w/Armor#Armor_toughness
                    // Only diamond and netherite have values greater than 0 here, so we just return 0.
                    0,
                    // Returns the knockback resistance value of the armor. While wearing this armor, the player is
                    // immune to knockback to some degree. If the player has a total knockback resistance value of 1 or greater
                    // from all armor pieces combined, they will not take any knockback at all.
                    // Only netherite has values greater than 0 here, so we just return 0.
                    0
            ));
    public static final Supplier<ArmorItem> LEAD_HELMET = ITEMS.register("lead_helmet", () -> new ArmorItem(
            // The armor material to use.
            LEAD_ARMOR_MATERIAL,
            // The armor type to use.
            ArmorItem.Type.HELMET,
            // The item properties where we set the durability.
            // ArmorItem.Type is an enum of five values: HELMET, CHESTPLATE, LEGGINGS, BOOTS, and BODY.
            // BODY is used for non-player entities like wolves or horses.
            // Vanilla armor materials determine this by using a base value and multiplying it with a type-specific constant.
            // The constants are 13 for BOOTS, 15 for LEGGINGS, 16 for CHESTPLATE, 11 for HELMET, and 16 for BODY.
            // If we don't want to use these ratios, we can set the durability normally.
            new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))
    ));
    public static final Supplier<ArmorItem> LEAD_CHESTPLATE = ITEMS.register("lead_chestplate", () -> new ArmorItem(
            LEAD_ARMOR_MATERIAL,
            ArmorItem.Type.CHESTPLATE,
            new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))
    ));
    public static final Supplier<ArmorItem> LEAD_LEGGINGS = ITEMS.register("lead_leggings", () -> new ArmorItem(
            LEAD_ARMOR_MATERIAL,
            ArmorItem.Type.LEGGINGS,
            new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))
    ));
    public static final Supplier<ArmorItem> LEAD_BOOTS = ITEMS.register("lead_boots", () -> new ArmorItem(
            LEAD_ARMOR_MATERIAL,
            ArmorItem.Type.BOOTS,
            new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15))
    ));
    public static void load(){
        team.neoradiance.immersiveadventuring.ImmersiveAdventuring.LOGGER.info("Loading LeadArmor");
    }
}
