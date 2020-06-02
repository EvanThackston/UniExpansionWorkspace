
package net.mcreator.universalexpansion.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.universalexpansion.itemgroup.UniversalSwordsItemGroup;
import net.mcreator.universalexpansion.UniversalexpansionModElements;

@UniversalexpansionModElements.ModElement.Tag
public class PhoenixBladeItem extends UniversalexpansionModElements.ModElement {
	@ObjectHolder("universalexpansion:end_blade")
	public static final Item block = null;
	public PhoenixBladeItem(UniversalexpansionModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 89759;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.4f, new Item.Properties().group(UniversalSwordsItemGroup.tab)) {
		}.setRegistryName("end_blade"));
	}
}
