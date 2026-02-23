package team.neoradiance.immersiveadventuring.common.iemetalexpansions.aluminum;


import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import team.neoradiance.immersiveadventuring.Lib;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import static blusunrize.immersiveengineering.api.IETags.getIngot;
import static blusunrize.immersiveengineering.api.utils.TagUtils.createItemWrapper;
import static team.neoradiance.immersiveadventuring.Register.ARMOR_MATERIALS;
import static team.neoradiance.immersiveadventuring.Register.ITEMS;

/**
 * Aluminum Armor Implementation
 * <p>
 * This class defines the aluminum armor material and registers aluminum armor items.
 * Aluminum armor is positioned between chainmail and iron armor in terms of protection and durability.
 * <p>
 * <h2>Armor Material Properties</h2>
 * <table border="1">
 *   <tr>
 *     <th>Property</th>
 *     <th>Value</th>
 *     <th>Description</th>
 *   </tr>
 *   <tr>
 *     <td>Defense Values</td>
 *     <td>Boots: 2, Leggings: 4, Chestplate: 6, Helmet: 2, Body: 4</td>
 *     <td>Protection values for each armor piece</td>
 *   </tr>
 *   <tr>
 *     <td>Enchantability</td>
 *     <td>7</td>
 *     <td>Lower than iron, representing aluminum's industrial nature</td>
 *   </tr>
 *   <tr>
 *     <td>Sound</td>
 *     <td>ARMOR_EQUIP_GENERIC</td>
 *     <td>Sound played when equipping this armor</td>
 *   </tr>
 *   <tr>
 *     <td>Repair Item</td>
 *     <td>Aluminum Ingot</td>
 *     <td>Item used to repair aluminum armor</td>
 *   </tr>
 *   <tr>
 *     <td>Toughness</td>
 *     <td>0</td>
 *     <td>Aluminum is a soft metal, so it has no additional damage reduction</td>
 *   </tr>
 *   <tr>
 *     <td>Knockback Resistance</td>
 *     <td>0</td>
 *     <td>Aluminum is lightweight, so it provides no knockback resistance</td>
 *   </tr>
 * </table>
 * <p>
 * <h2>Armor Item Properties</h2>
 * <table border="1">
 *   <tr>
 *     <th>Armor Piece</th>
 *     <th>Durability</th>
 *     <th>Description</th>
 *   </tr>
 *   <tr>
 *     <td>Helmet</td>
 *     <td>225</td>
 *     <td>15 * 15 (base * helmet multiplier)</td>
 *   </tr>
 *   <tr>
 *     <td>Chestplate</td>
 *     <td>240</td>
 *     <td>15 * 16 (base * chestplate multiplier)</td>
 *   </tr>
 *   <tr>
 *     <td>Leggings</td>
 *     <td>225</td>
 *     <td>15 * 15 (base * leggings multiplier)</td>
 *   </tr>
 *   <tr>
 *     <td>Boots</td>
 *     <td>195</td>
 *     <td>15 * 13 (base * boots multiplier)</td>
 *   </tr>
 * </table>
 * <p>
 * <h2>Design Philosophy</h2>
 * <ul>
 *   <li><strong>Protection</strong>: Aluminum armor provides more protection than chainmail but less than iron</li>
 *   <li><strong>Durability</strong>: More durable than chainmail but less than iron</li>
 *   <li><strong>Special Properties</strong>: Aluminum is lightweight and soft, so it has no additional toughness or knockback resistance</li>
 *   <li><strong>Enchantability</strong>: Lower than iron, reflecting its industrial metal nature</li>
 *   <li><strong>Balance</strong>: Provides an early-game alternative to iron armor with different characteristics</li>
 * </ul>
 */
public class AluminumArmor {
    // ARMOR_MATERIALS is a DeferredRegister<ArmorMaterial>
    // We place aluminum somewhere between chainmail and iron.
    public static final Holder<ArmorMaterial> ALUMINUM_ARMOR_MATERIAL =
            ARMOR_MATERIALS.register("aluminum", () -> new ArmorMaterial(
                    // Determines the defense value of this armor material, depending on what armor piece it is.
                    Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 6);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 4);
                    }),
                    // Determines the enchantability of the tier. This represents how good the enchantments on this armor will be.
                    // Gold uses 25, we put aluminum slightly below that--no,no,no.
                    // --Just a kind of industry metal.
                    7,
                    // Determines the sound played when equipping this armor.
                    // This is wrapped with a Holder.
                    SoundEvents.ARMOR_EQUIP_GENERIC,
                    // Determines the repair item for this armor.
                    () -> Ingredient.of(createItemWrapper(getIngot("aluminum"))),//MPCBexplorer:Use this way!
                    // Determines the texture locations of the armor to apply when rendering
                    // This can also be specified by overriding 'IItemExtension#getArmorTexture' on your item if the armor texture needs to be more dynamic
                    List.of(
                            // Creates a new armor texture that will be located at:
                            // - 'assets/mod_id/textures/models/armor/aluminum_layer_1.png' for the outer texture
                            // - 'assets/mod_id/textures/models/armor/aluminum_layer_2.png' for the inner texture (only legs)
                            new ArmorMaterial.Layer(
                                    ResourceLocation.fromNamespaceAndPath(Lib.MOD_ID, "aluminum")
                            )
                            /*

                            MPCBexplorer: Only be used for dyeable armor

                            // Creates a new armor texture that will be rendered on top of the previous at:
                            // - 'assets/mod_id/textures/models/armor/aluminum_layer_1_overlay.png' for the outer texture
                            // - 'assets/mod_id/textures/models/armor/aluminum_layer_2_overlay.png' for the inner texture (only legs)
                            // 'true' means that the armor material is dyeable; however, the item must also be added to the 'minecraft:dyeable' tag
                            new ArmorMaterial.Layer(
                                    ResourceLocation.fromNamespaceAndPath(Lib.Modid, "aluminum"), "_overlay", true
                            )
                            */
                    ),
                    // Returns the toughness value of the armor. The toughness value is an additional value included in
                    // damage calculation, for more information, refer to the Minecraft Wiki's article on armor mechanics:
                    // https://minecraft.wiki/w/Armor#Armor_toughness
                    // Only diamond and netherite have values greater than 0 here, so we just return 0.
                    // Aluminum is soft so we set it to 0.
                    0,
                    // Returns the knockback resistance value of the armor. While wearing this armor, the player is
                    // immune to knockback to some degree. If the player has a total knockback resistance value of 1 or greater
                    // from all armor pieces combined, they will not take any knockback at all.
                    // Only netherite has values greater than 0 here, so we just return 0.
                    // Aluminum is light also.
                    0
            ));
    public static final Supplier<ArmorItem> ALUMINUM_HELMET = ITEMS.register("aluminum_helmet", () -> new ArmorItem(
            // The armor material to use.
            ALUMINUM_ARMOR_MATERIAL,
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
    public static final Supplier<ArmorItem> ALUMINUM_CHESTPLATE = ITEMS.register("aluminum_chestplate", () -> new ArmorItem(
            ALUMINUM_ARMOR_MATERIAL,
            ArmorItem.Type.CHESTPLATE,
            new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))
    ));
    public static final Supplier<ArmorItem> ALUMINUM_LEGGINGS = ITEMS.register("aluminum_leggings", () -> new ArmorItem(
            ALUMINUM_ARMOR_MATERIAL,
            ArmorItem.Type.LEGGINGS,
            new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))
    ));
    public static final Supplier<ArmorItem> ALUMINUM_BOOTS = ITEMS.register("aluminum_boots", () -> new ArmorItem(
            ALUMINUM_ARMOR_MATERIAL,
            ArmorItem.Type.BOOTS,
            new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15))
    ));

    public static void load() {
        team.neoradiance.immersiveadventuring.ImmersiveAdventuring.LOGGER.info("Loading AluminumArmor");
    }
}