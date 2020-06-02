package net.mcreator.universalexpansion.procedures;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.universalexpansion.world.dimension.OrbitDimension;
import net.mcreator.universalexpansion.UniversalexpansionModElements;

@UniversalexpansionModElements.ModElement.Tag
public class ShowDimensionIdCommandExecutedProcedure extends UniversalexpansionModElements.ModElement {
	public ShowDimensionIdCommandExecutedProcedure(UniversalexpansionModElements instance) {
		super(instance, 33);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ShowDimensionIdCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ShowDimensionIdCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if ((entity.hasPermissionLevel((int) 2))) {
			if (entity instanceof PlayerEntity && !world.isRemote) {
				((PlayerEntity) entity)
						.sendStatusMessage(new StringTextComponent((("This dimension's id is:") + "" + ((OrbitDimension.type.getId())))), (false));
			}
		} else {
			if (entity instanceof PlayerEntity && !world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("no, i dont think i will."), (false));
			}
		}
	}
}
