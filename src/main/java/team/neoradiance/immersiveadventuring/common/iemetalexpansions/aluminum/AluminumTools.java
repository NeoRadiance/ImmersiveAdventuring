package team.neoradiance.immersiveadventuring.common.iemetalexpansions.aluminum;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

import java.util.function.Supplier;

import static blusunrize.immersiveengineering.api.IETags.getIngot;
import static blusunrize.immersiveengineering.api.utils.TagUtils.createItemWrapper;
import static team.neoradiance.immersiveadventuring.Register.ITEMS;

/**
 * Aluminum Tools Implementation
 * <p>
 * This class defines the aluminum tool tier and registers aluminum tool items.
 * Aluminum tools are positioned between stone and iron tools in terms of performance.
 * <p>
 * <h2>Tool Tier Properties</h2>
 * <table border="1">
 *   <tr>
 *     <th>Property</th>
 *     <th>Value</th>
 *     <th>Description</th>
 *   </tr>
 *   <tr>
 *     <td>Invalid Blocks Tag</td>
 *     <td>INCORRECT_FOR_ALUMINUM_TOOL</td>
 *     <td>Tag of blocks that aluminum tools cannot break</td>
 *   </tr>
 *   <tr>
 *     <td>Durability</td>
 *     <td>181</td>
 *     <td>Between stone (131) and iron (250), reflecting aluminum's softness</td>
 *   </tr>
 *   <tr>
 *     <td>Mining Speed</td>
 *     <td>5.0f</td>
 *     <td>Between stone (4.0) and iron (6.0)</td>
 *   </tr>
 *   <tr>
 *     <td>Attack Damage Bonus</td>
 *     <td>2.0f</td>
 *     <td>Same as iron, representing aluminum's effectiveness as a tool material</td>
 *   </tr>
 *   <tr>
 *     <td>Enchantability</td>
 *     <td>7</td>
 *     <td>Lower than iron, reflecting aluminum's industrial nature</td>
 *   </tr>
 *   <tr>
 *     <td>Repair Item</td>
 *     <td>Aluminum Ingot</td>
 *     <td>Item used to repair aluminum tools</td>
 *   </tr>
 * </table>
 * <p>
 * <h2>Tool Item Properties</h2>
 * <table border="1">
 *   <tr>
 *     <th>Tool</th>
 *     <th>Attack Damage</th>
 *     <th>Attack Speed</th>
 *     <th>Description</th>
 *   </tr>
 *   <tr>
 *     <td>Sword</td>
 *     <td>5.0 (2.0 + 3)</td>
 *     <td>2.0 (-2.0 modifier)</td>
 *     <td>Faster attack speed due to aluminum's lightweight nature</td>
 *   </tr>
 *   <tr>
 *     <td>Pickaxe</td>
 *     <td>3.0 (2.0 + 1)</td>
 *     <td>1.6 (-2.4 modifier)</td>
 *     <td>Faster mining due to aluminum's lightweight nature</td>
 *   </tr>
 *   <tr>
 *     <td>Axe</td>
 *     <td>5.5 (2.0 + 3.5)</td>
 *     <td>1.6 (-2.4 modifier)</td>
 *     <td>Faster chopping due to aluminum's lightweight nature</td>
 *   </tr>
 *   <tr>
 *     <td>Shovel</td>
 *     <td>3.5 (2.0 + 1.5)</td>
 *     <td>1.4 (-2.6 modifier)</td>
 *     <td>Faster digging due to aluminum's lightweight nature</td>
 *   </tr>
 *   <tr>
 *     <td>Hoe</td>
 *     <td>3.0 (2.0 + 1)</td>
 *     <td>1.6 (-2.4 modifier)</td>
 *     <td>Faster tilling due to aluminum's lightweight nature</td>
 *   </tr>
 * </table>
 * <p>
 * <h2>Design Philosophy</h2>
 * <ul>
 *   <li><strong>Performance</strong>: Aluminum tools are better than stone but worse than iron</li>
 *   <li><strong>Durability</strong>: More durable than stone but less than iron, reflecting aluminum's softness</li>
 *   <li><strong>Enchantability</strong>: Lower than iron, reflecting aluminum's industrial nature</li>
 *   <li><strong>Unique Traits</strong>: Aluminum's lightweight nature is reflected in faster attack speeds across all tools</li>
 *   <li><strong>Balance</strong>: Provides an early-game alternative to iron tools with different characteristics</li>
 *   <li><strong>Realism</strong>: Aluminum's lightweight properties are emphasized through faster tool speeds</li>
 * </ul>
 */
public class AluminumTools {
    // We place aluminum somewhere little more than iron.
    public static final Tier ALUMINUM_TIER = new SimpleTier(
            // The tag that determines what blocks this tool cannot break. See below for
            // more information.
            AluminumTags.INCORRECT_FOR_ALUMINUM_TOOL,
            // Determines the durability of the tier.
            // Stone is 131, iron is 250.
            // Aluminum is a soft metal.
            181,
            // Determines the mining speed of the tier. Unused by swords.
            // Stone uses 4, iron uses 6.
            5f,
            // Determines the attack damage bonus. Different tools use this differently. For
            // example, swords do (getAttackDamageBonus() + 4) damage.
            // Stone uses 1, iron uses 2, corresponding to 5 and 6 attack damage for swords,
            // respectively; our sword does 6.5 damage now.
            2,
            // Determines the enchantability of the tier. This represents how good the
            // enchantments on this tool will be.
            // Gold uses 22, we put aluminum slightly below that.
            // A metal in industry.
            7,
            // Determines the repair ingredient of the tier. Use a supplier for lazy
            // initializing.
            () -> Ingredient.of(createItemWrapper(getIngot("aluminum"))));
    public static final Supplier<SwordItem> ALUMINUM_SWORD = ITEMS.register("aluminum_sword", () -> new SwordItem(
            // The tier to use.
            ALUMINUM_TIER,
            // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
                    // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                    SwordItem.createAttributes(
                            // The tier to use.
                            ALUMINUM_TIER,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            3,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            // You know aluminum is so light.
                            -2
                    )
            )
    ));
    public static final Supplier<Item> ALUMINUM_PICKAXE = ITEMS.register("aluminum_pickaxe", () -> new PickaxeItem(
            // The tier to use.
            ALUMINUM_TIER,
            // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
                    // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                    PickaxeItem.createAttributes(
                            // The tier to use.
                            ALUMINUM_TIER,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            1,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            // You know aluminum is so light.
                            -2.4f
                    )
            )
    ));
    public static final Supplier<Item> ALUMINUM_AXE = ITEMS.register("aluminum_axe", () -> new AxeItem(
            // The tier to use.
            ALUMINUM_TIER,
            // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
                    // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                    AxeItem.createAttributes(
                            // The tier to use.
                            ALUMINUM_TIER,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            3.5f,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            // You know aluminum is so light.
                            -2.4f
                    )
            )
    ));
    public static final Supplier<Item> ALUMINUM_SHOVEL = ITEMS.register("aluminum_shovel", () -> new ShovelItem(
            // The tier to use.
            ALUMINUM_TIER,
            // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
                    // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                    ShovelItem.createAttributes(
                            // The tier to use.
                            ALUMINUM_TIER,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            1.5f,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            // You know aluminum is so light.
                            -2.6f
                    )
            )
    ));
    public static final Supplier<Item> ALUMINUM_HOE = ITEMS.register("aluminum_hoe", () -> new HoeItem(
            // The tier to use.
            ALUMINUM_TIER,
            // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
                    // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                    HoeItem.createAttributes(
                            // The tier to use.
                            ALUMINUM_TIER,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            1,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            -2.4f
                    )
            )
    ));

    public static void load() {
        team.neoradiance.immersiveadventuring.ImmersiveAdventuring.LOGGER.info("Loading AluminumTools");
    }
}