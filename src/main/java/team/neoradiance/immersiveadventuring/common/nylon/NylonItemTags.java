package team.neoradiance.immersiveadventuring.common.nylon;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 * Nylon Item Tags Definitions
 * <p>
 * This class defines all item tags for nylon-related content.
 * Use these tags in ModItemTagsProvider to register actual tag data.
 */
public class NylonItemTags
{
	public static final TagKey<Item> NYLON_INGOTS = ItemTags.create(
			ResourceLocation.fromNamespaceAndPath("c", "ingots/nylon"));
	
	public static final TagKey<Item> NYLON_PLATES = ItemTags.create(
			ResourceLocation.fromNamespaceAndPath("c", "plates/nylon"));
}
