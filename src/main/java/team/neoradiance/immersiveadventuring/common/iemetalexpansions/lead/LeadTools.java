package team.neoradiance.immersiveadventuring.common.iemetalexpansions.lead;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

import java.util.function.Supplier;

import static blusunrize.immersiveengineering.api.IETags.getIngot;
import static blusunrize.immersiveengineering.api.utils.TagUtils.createItemWrapper;
import static team.neoradiance.immersiveadventuring.Register.ITEMS;

/**
 * Lead Tools Implementation
 * <p>
 * This class defines the lead tool tier and registers lead tool items.
 * Lead tools are positioned between stone and iron tools in terms of performance.
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
 *     <td>INCORRECT_FOR_LEAD_TOOL</td>
 *     <td>Tag of blocks that lead tools cannot break</td>
 *   </tr>
 *   <tr>
 *     <td>Durability</td>
 *     <td>200</td>
 *     <td>Between stone (131) and iron (250)</td>
 *   </tr>
 *   <tr>
 *     <td>Mining Speed</td>
 *     <td>5.0f</td>
 *     <td>Between stone (4.0) and iron (6.0)</td>
 *   </tr>
 *   <tr>
 *     <td>Attack Damage Bonus</td>
 *     <td>2.5f</td>
 *     <td>Between stone (1.0) and iron (2.0)</td>
 *   </tr>
 *   <tr>
 *     <td>Enchantability</td>
 *     <td>20</td>
 *     <td>Slightly below gold (22), representing how good enchantments will be</td>
 *   </tr>
 *   <tr>
 *     <td>Repair Item</td>
 *     <td>Lead Ingot</td>
 *     <td>Item used to repair lead tools</td>
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
 *     <td>5.5 (2.5 + 3)</td>
 *     <td>1.6 (-2.4 modifier)</td>
 *     <td>Standard sword attributes</td>
 *   </tr>
 *   <tr>
 *     <td>Pickaxe</td>
 *     <td>3.5 (2.5 + 1)</td>
 *     <td>1.2 (-2.8 modifier)</td>
 *     <td>Standard pickaxe attributes</td>
 *   </tr>
 *   <tr>
 *     <td>Axe</td>
 *     <td>6.0 (2.5 + 3.5)</td>
 *     <td>0.9 (-2.7 modifier)</td>
 *     <td>Slower but more damaging than other tools</td>
 *   </tr>
 *   <tr>
 *     <td>Shovel</td>
 *     <td>4.0 (2.5 + 1.5)</td>
 *     <td>1.0 (-3.0 modifier)</td>
 *     <td>Standard shovel attributes</td>
 *   </tr>
 *   <tr>
 *     <td>Hoe</td>
 *     <td>3.5 (2.5 + 1)</td>
 *     <td>1.2 (-2.8 modifier)</td>
 *     <td>Standard hoe attributes</td>
 *   </tr>
 * </table>
 * <p>
 * <h2>Design Philosophy</h2>
 * <ul>
 *   <li><strong>Performance</strong>: Lead tools are better than stone but worse than iron</li>
 *   <li><strong>Durability</strong>: More durable than stone but less than iron</li>
 *   <li><strong>Enchantability</strong>: Higher than iron, making it good for early-game enchanted tools</li>
 *   <li><strong>Unique Traits</strong>: Lead's weight is reflected in slightly slower attack speeds but higher damage</li>
 *   <li><strong>Balance</strong>: Provides an alternative to iron tools for players who find lead more easily</li>
 * </ul>
 */
public class LeadTools {
    // We place lead somewhere little more than iron.
    public static final Tier LEAD_TIER = new SimpleTier(
            // The tag that determines what blocks this tool cannot break. See below for
            // more information.
            LeadTags.INCORRECT_FOR_LEAD_TOOL,
            // Determines the durability of the tier.
            // Stone is 131, iron is 250.
            200,
            // Determines the mining speed of the tier. Unused by swords.
            // Stone uses 4, iron uses 6.
            5f,
            // Determines the attack damage bonus. Different tools use this differently. For
            // example, swords do (getAttackDamageBonus() + 4) damage.
            // Stone uses 1, iron uses 2, corresponding to 5 and 6 attack damage for swords,
            // respectively; our sword does 6.5 damage now.
            // Lead is poisonous, isn't it?
            2.5f,
            // Determines the enchantability of the tier. This represents how good the
            // enchantments on this tool will be.
            // Gold uses 22, we put lead slightly below that.
            // Lead comes from the old magic in the Middle Ages.
            20,
            // Determines the repair ingredient of the tier. Use a supplier for lazy
            // initializing.
            () -> Ingredient.of(createItemWrapper(getIngot("lead"))));
    public static final Supplier<SwordItem> LEAD_SWORD = ITEMS.register("lead_sword", () -> new SwordItem(
            // The tier to use.
            LEAD_TIER,
            // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
                    // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                    SwordItem.createAttributes(
                            // The tier to use.
                            LEAD_TIER,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            3,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            -2.4f
                    )
            )
    ));
    public static final Supplier<Item> LEAD_PICKAXE = ITEMS.register("lead_pickaxe", () -> new PickaxeItem(
            // The tier to use.
            LEAD_TIER,
            // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
                    // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                    AxeItem.createAttributes(
                            // The tier to use.
                            LEAD_TIER,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            1,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            -2.8f
                    )
            )
    ));
    public static final Supplier<Item> LEAD_AXE = ITEMS.register("lead_axe", () -> new AxeItem(
            // The tier to use.
            LEAD_TIER,
            // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
                    // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                    AxeItem.createAttributes(
                            // The tier to use.
                            LEAD_TIER,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            3.5f,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            // You know lead is heavy.
                            -2.7f
                    )
            )
    ));
    public static final Supplier<Item> LEAD_SHOVEL = ITEMS.register("lead_shovel", () -> new ShovelItem(
            // The tier to use.
            LEAD_TIER,
            // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
                    // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                    ShovelItem.createAttributes(
                            // The tier to use.
                            LEAD_TIER,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            1.5f,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            -3f
                    )
            )
    ));
    public static final Supplier<Item> LEAD_HOE = ITEMS.register("lead_hoe", () -> new HoeItem(
            // The tier to use.
            LEAD_TIER,
            // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
                    // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                    HoeItem.createAttributes(
                            // The tier to use.
                            LEAD_TIER,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            1,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            -2.8f
                    )
            )
    ));

    public static void load() {
        team.neoradiance.immersiveadventuring.ImmersiveAdventuring.LOGGER.info("Loading LeadTools");
    }
}