package team.neoradiance.immersiveadventuring.common.iemetalexpansions.lead;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;

import java.util.function.Supplier;

import static team.neoradiance.immersiveadventuring.Register.ITEMS;

public class LeadTools {
    // We place lead somewhere between stone and iron.
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
            // respectively; our sword does 5.5 damage now.
            1.5f,
            // Determines the enchantability of the tier. This represents how good the
            // enchantments on this tool will be.
            // Gold uses 22, we put copper slightly below that.
            20,
            // Determines the repair ingredient of the tier. Use a supplier for lazy
            // initializing.
            () -> Ingredient.of(Tags.Items.INGOTS_COPPER));
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
                            1,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            -2.8f
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

