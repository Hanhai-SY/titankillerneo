package net.hanhai.titankillerneo.procedures;

import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.hanhai.titankillerneo.init.TitankillerneoModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Wudi3Procedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (hasEntityInInventory(entity, new ItemStack(TitankillerneoModItems.TITAN_KILLER.get()))) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}

            if (entity instanceof Player) {
              Player player = (Player) entity;
              player.setHealth(player.getMaxHealth());
              player.getFoodData().setFoodLevel(500);
              player.getFoodData().setSaturation(500);
            }
        }
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}