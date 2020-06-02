
package net.mcreator.universalexpansion.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;

import net.mcreator.universalexpansion.block.MoonStoneBlock;
import net.mcreator.universalexpansion.UniversalexpansionModElements;

@UniversalexpansionModElements.ModElement.Tag
public class Orbit1Biome extends UniversalexpansionModElements.ModElement {
	@ObjectHolder("universalexpansion:orbit_1")
	public static final CustomBiome biome = null;
	public Orbit1Biome(UniversalexpansionModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(0.2f).temperature(0.5f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(MoonStoneBlock.block.getDefaultState(),
							MoonStoneBlock.block.getDefaultState(), MoonStoneBlock.block.getDefaultState())));
			setRegistryName("orbit_1");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
		}
	}
}
