package team.neoradiance.immersiveadventuring.utilities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;

public class TagWrapper<T>
{
	public final TagKey<T> tag;
	public ArrayList<T> list = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public TagWrapper(Class<T> type, String namespace, String path)
	{
		if(type==Block.class)
		{
			this.tag = (TagKey<T>)BlockTags.create(ResourceLocation.fromNamespaceAndPath(namespace, path));
		}
		else if(type==Item.class)
		{
			this.tag = (TagKey<T>)ItemTags.create(ResourceLocation.fromNamespaceAndPath(namespace, path));
		}
		else
		{
			throw new IllegalArgumentException("Unsupported type: "+type);
		}
	}

	public void add(T t)
	{
		list.add(t);
	}
}
