package team.neoradiance.immersiveadventuring;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.conditions.ICondition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utilities {
    /**
     * 照搬blusunrize.immersiveengineering.data.recipes.IERecipeProvider::pathCount(IERecipeProvider:41)
     * 仅修改修饰符，原无static
     */
    protected static final HashMap<String, Integer> pathCount = new HashMap<>();
    /**
     * 照搬blusunrize.immersiveengineering.data.recipes.builder.IERecipeBuilder::conditions(IERecipeBuilder:18)
     * 仅修改修饰符，原无static
     */
    protected static final List<ICondition> conditions = new ArrayList<>();

    /**
     * Converts a string to a ResourceLocation for item or recipe registration
     * <p>
     * This method is adapted from Immersive Engineering's {@code IERecipeProvider.ToRL()} method,
     * with modifications to use the mod's own namespace instead of IE's.
     * <p>
     * <h2>Path Handling</h2>
     * <ul>
     *   <li><strong>Default Path</strong>: If the input string does not contain a slash, it is prepended with "crafting/"</li>
     *   <li><strong>Duplicate Handling</strong>: If a path is used multiple times, a counter is appended to ensure uniqueness</li>
     *   <li><strong>Namespace</strong>: Uses "immersiveadventuring" instead of IE's</li>
     * </ul>
     * <p>
     * <h2>Usage Examples</h2>
     * <pre>
     * // Generates: immersiveadventuring:crafting/nylon_ingot
     * toRL("nylon_ingot");
     * // Generates: immersiveadventuring:metalpress/plate_nylon
     * toRL("metalpress/plate_nylon");
     * // Generates: immersiveadventuring:crafting/nylon_ingot2 (if already used once)
     * toRL("nylon_ingot");
     * </pre>
     * <p>
     * <h2>Importance in Recipe Generation</h2>
     * <ul>
     *   <li><strong>Path Consistency</strong>: Ensures recipes are generated in the correct directory structure</li>
     *   <li><strong>Namespace Correctness</strong>: Prevents recipes from being generated in the wrong mod's namespace</li>
     *   <li><strong>Uniqueness</strong>: Avoids recipe path conflicts by appending counters to duplicate paths</li>
     *   <li><strong>Compatibility</strong>: Maintains compatibility with IE's recipe loading system while using the correct namespace</li>
     * </ul>
     *
     * @param s The string representation of the item or recipe path
     * @return The ResourceLocation for the item or recipe
     */
    public static ResourceLocation toRL(String s) {
        if (!s.contains("/"))
            s = "crafting/" + s;
        if (pathCount.containsKey(s)) {
            int count = pathCount.get(s) + 1;
            pathCount.put(s, count);
            return iaLoc(s + count);
        }
        pathCount.put(s, 1);
        return iaLoc(s);
    }

    /**
     * 从 Item 对象获取其 ResourceLocation
     *
     * @param item 物品对象
     * @return 物品的 ResourceLocation
     */
    public static ResourceLocation getResourceLocation(Item item) {
        return BuiltInRegistries.ITEM.getKey(item);
    }

    /**
     * 获取物品的命名空间（mod_id）
     *
     * @param item 物品对象
     * @return 物品的命名空间
     */
    public static String getNamespace(Item item) {
        return getResourceLocation(item).getNamespace();
    }

    /**
     * 获取物品的路径（物品名）
     *
     * @param item 物品对象
     * @return 物品的路径
     */
    public static String getPath(Item item) {
        return getResourceLocation(item).getPath();
    }

    /**
     * 获取当前配方的条件数组
     * 照搬blusunrize.immersiveengineering.data.recipes.builder.IERecipeBuilder::conditions(IERecipeBuilder:26-29)
     * 仅修改修饰符，原仅有protected
     *
     * @return 条件数组
     */
    public static ICondition[] getConditions() {
        return conditions.toArray(ICondition[]::new);
    }

    /**
     * Creates a ResourceLocation using the mod's namespace
     * <p>
     * This method is a convenience utility to create ResourceLocation objects
     * with the mod's namespace ("immersiveadventuring") pre-configured.
     * <p>
     * <h2>Importance</h2>
     * <ul>
     *   <li><strong>Namespace Consistency</strong>: Ensures all ResourceLocation objects use the correct namespace</li>
     *   <li><strong>Error Prevention</strong>: Avoids typos in namespace strings</li>
     *   <li><strong>Maintainability</strong>: Makes it easier to change the mod's namespace if needed</li>
     *   <li><strong>Compatibility</strong>: Works seamlessly with Minecraft's ResourceLocation system</li>
     * </ul>
     * <p>
     * <h2>Usage Examples</h2>
     * <pre>
     * // Creates: immersiveadventuring:nylon_ingot
     * iaLoc("nylon_ingot");
     *
     * // Creates: immersiveadventuring:metalpress/plate_nylon
     * iaLoc("metalpress/plate_nylon");
     * </pre>
     * <p>
     * <h2>Relation to IE's System</h2>
     * <p>
     * This method serves the same purpose as IE's {@code IEApi.ieLoc()} method,
     * but uses the mod's own namespace instead of IE's. This is crucial because:
     * <ul>
     *   <li>Minecraft only allows mods to modify data in their own namespace</li>
     *   <li>IE can still find and use recipes in other mods' namespaces</li>
     *   <li>It maintains clear separation between mod data</li>
     * </ul>
     *
     * @param path The path component of the ResourceLocation
     * @return A ResourceLocation with the mod's namespace and the specified path
     */
    public static ResourceLocation iaLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(Lib.MOD_ID, path);
    }
}