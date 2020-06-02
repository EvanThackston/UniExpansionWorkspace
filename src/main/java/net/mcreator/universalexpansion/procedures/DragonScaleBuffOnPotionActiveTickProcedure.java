package net.mcreator.universalexpansion.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.universalexpansion.UniversalexpansionModElements;

@UniversalexpansionModElements.ModElement.Tag
public class DragonScaleBuffOnPotionActiveTickProcedure extends UniversalexpansionModElements.ModElement {
	public DragonScaleBuffOnPotionActiveTickProcedure(UniversalexpansionModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DragonScaleBuffOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 60, (int) 1, (true), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 60, (int) 0, (true), (false)));
	}
}
