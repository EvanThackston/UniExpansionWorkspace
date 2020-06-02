package net.mcreator.universalexpansion.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.universalexpansion.UniversalexpansionModElements;

@UniversalexpansionModElements.ModElement.Tag
public class MeteriteLazerRifleBulletHitsLivingEntityProcedure extends UniversalexpansionModElements.ModElement {
	public MeteriteLazerRifleBulletHitsLivingEntityProcedure(UniversalexpansionModElements instance) {
		super(instance, 35);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MeteriteLazerRifleBulletHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 8);
	}
}
