package net.mcreator.universalexpansion.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.universalexpansion.potion.DragonScaleBuffPotion;
import net.mcreator.universalexpansion.UniversalexpansionModElements;

@UniversalexpansionModElements.ModElement.Tag
public class DragonScaleBodyTickEventProcedure extends UniversalexpansionModElements.ModElement {
	public DragonScaleBodyTickEventProcedure(UniversalexpansionModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DragonScaleBodyTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(DragonScaleBuffPotion.potion, (int) 60, (int) 0));
	}
}
