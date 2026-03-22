package team.neoradiance.immersiveadventuring.common.nylon;

import net.minecraft.world.item.Item;
import team.neoradiance.immersiveadventuring.common.nylon.items.NylonIngotItem;
import team.neoradiance.immersiveadventuring.common.nylon.items.NylonPlateItem;
import team.neoradiance.immersiveadventuring.utilities.TagWrapper;

/**
 * Nylon Item Tags Definitions
 * <p>
 * This class defines all item tags for nylon-related content.
 * Use these tags in ModItemTagsProvider to register actual tag data.
 */
public class NylonItemTags
{
	public static final TagWrapper<Item> NYLON_INGOTS = new TagWrapper<>(Item.class, "c", "ingots/nylon");
	public static final TagWrapper<Item> NYLON_PLATES = new TagWrapper<>(Item.class, "c", "plates/nylon");

	static
	{
		NYLON_INGOTS.add(NylonIngotItem.NYLON_INGOT_ITEM.get());
	}

	static
	{
		NYLON_PLATES.add(NylonPlateItem.NYLON_PLATE_ITEM.get());
	}
}
