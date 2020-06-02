package net.mcreator.universalexpansion.procedures;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.Explosion;
import net.minecraft.world.Difficulty;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.universalexpansion.world.dimension.OrbitDimension;
import net.mcreator.universalexpansion.UniversalexpansionModElements;

import java.util.Collections;

@UniversalexpansionModElements.ModElement.Tag
public class WarpOrbitProcedure extends UniversalexpansionModElements.ModElement {
	public WarpOrbitProcedure(UniversalexpansionModElements instance) {
		super(instance, 32);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WarpOrbit!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WarpOrbit!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WarpOrbit!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WarpOrbit!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WarpOrbit!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((entity.dimension.getId()) == 0)) {
			if (((entity.getPosY()) > 300)) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
						DimensionType destinationType = OrbitDimension.type;
						ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) _ent, true, "field_184851_cj");
						ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
						((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(4, 0));
						((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
								nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
						for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
							((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
						}
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
			}
		} else {
			if (((entity.dimension.getId()) == 2)) {
				if (((entity.getPosY()) < (-2))) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							DimensionType destinationType = DimensionType.OVERWORLD;
							ObfuscationReflectionHelper.setPrivateValue(ServerPlayerEntity.class, (ServerPlayerEntity) _ent, true, "field_184851_cj");
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(4, 0));
							((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
									nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
							((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
							for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
							}
							((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
						}
					}
					if ((world.getDifficulty() == Difficulty.HARD)) {
						{
							Entity _ent = entity;
							_ent.setPositionAndUpdate(x, 280, z);
							if (_ent instanceof ServerPlayerEntity) {
								((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, 280, z, _ent.rotationYaw, _ent.rotationPitch,
										Collections.emptySet());
							}
						}
						if (!world.isRemote) {
							world.createExplosion(null, (int) x, (int) y, (int) z, (float) 1, Explosion.Mode.BREAK);
						}
						entity.setFire((int) 15);
					} else {
						if ((world.getDifficulty() == Difficulty.NORMAL)) {
							{
								Entity _ent = entity;
								_ent.setPositionAndUpdate(x, 280, z);
								if (_ent instanceof ServerPlayerEntity) {
									((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, 280, z, _ent.rotationYaw, _ent.rotationPitch,
											Collections.emptySet());
								}
							}
							entity.setFire((int) 5);
						} else {
							if ((world.getDifficulty() == Difficulty.EASY)) {
								{
									Entity _ent = entity;
									_ent.setPositionAndUpdate(x, 280, z);
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, 280, z, _ent.rotationYaw, _ent.rotationPitch,
												Collections.emptySet());
									}
								}
								entity.setFire((int) 1);
							} else {
								{
									Entity _ent = entity;
									_ent.setPositionAndUpdate(x, 280, z);
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, 280, z, _ent.rotationYaw, _ent.rotationPitch,
												Collections.emptySet());
									}
								}
								if (entity instanceof PlayerEntity && !world.isRemote) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("fricking stupid peaceful mode"), (false));
								}
								entity.setFire((int) 999999);
								if (entity instanceof LivingEntity)
									((LivingEntity) entity)
											.addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 999999, (int) 5, (true), (true)));
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			int i = (int) entity.getPosX();
			int j = (int) entity.getPosY();
			int k = (int) entity.getPosZ();
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
