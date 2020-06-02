package net.mcreator.universalexpansion.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.Entity;

import net.mcreator.universalexpansion.item.PhoenixBladeItem;
import net.mcreator.universalexpansion.item.DragonScaleItem;
import net.mcreator.universalexpansion.UniversalexpansionModElements;

@UniversalexpansionModElements.ModElement.Tag
public class VanillaCustomDropsProcedure extends UniversalexpansionModElements.ModElement {
	public VanillaCustomDropsProcedure(UniversalexpansionModElements instance) {
		super(instance, 8);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure VanillaCustomDrops!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure VanillaCustomDrops!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure VanillaCustomDrops!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure VanillaCustomDrops!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure VanillaCustomDrops!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		double loot = 0;
		if ((entity instanceof EnderDragonEntity)) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, x, y, z, (int) 500, 3, 3, 3, 1);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.ENCHANT, x, y, z, (int) 500, 3, 3, 3, 1);
			}
			loot = (double) (Math.random() + (Math.random() + Math.random()));
			if (((loot) == 0)) {
				if (!world.isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(DragonScaleItem.body, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			} else {
				if (((loot) == 1)) {
					if (!world.isRemote) {
						ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(DragonScaleItem.legs, (int) (1)));
						entityToSpawn.setPickupDelay(10);
						world.addEntity(entityToSpawn);
					}
				} else {
					if (((loot) == 2)) {
						if (!world.isRemote) {
							ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(DragonScaleItem.boots, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.addEntity(entityToSpawn);
						}
					} else {
						if (!world.isRemote) {
							ItemEntity entityToSpawn = new ItemEntity(world, x, y, z, new ItemStack(PhoenixBladeItem.block, (int) (1)));
							entityToSpawn.setPickupDelay(10);
							world.addEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			int i = (int) entity.getPosX();
			int j = (int) entity.getPosY();
			int k = (int) entity.getPosZ();
			World world = entity.world;
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
