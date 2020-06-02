
package net.mcreator.universalexpansion.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.universalexpansion.item.MeteoriteSwordItem;
import net.mcreator.universalexpansion.UniversalexpansionModElements;

@UniversalexpansionModElements.ModElement.Tag
public class UniversalSwordsItemGroup extends UniversalexpansionModElements.ModElement {
	public UniversalSwordsItemGroup(UniversalexpansionModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabuniversal_swords") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(MeteoriteSwordItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
