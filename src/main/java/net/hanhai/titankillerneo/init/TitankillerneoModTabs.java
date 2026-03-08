/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hanhai.titankillerneo.init;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.hanhai.titankillerneo.TitankillerneoMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TitankillerneoModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TitankillerneoMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(TitankillerneoModItems.TITAN_KILLER.get());
		}
	}
}