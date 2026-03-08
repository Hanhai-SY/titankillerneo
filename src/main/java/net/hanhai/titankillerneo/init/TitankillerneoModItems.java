/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.hanhai.titankillerneo.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.hanhai.titankillerneo.item.TitanKillerItem;
import net.hanhai.titankillerneo.TitankillerneoMod;

import java.util.function.Function;

public class TitankillerneoModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(TitankillerneoMod.MODID);
	public static final DeferredItem<Item> TITAN_KILLER = register("titan_killer", TitanKillerItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}
}