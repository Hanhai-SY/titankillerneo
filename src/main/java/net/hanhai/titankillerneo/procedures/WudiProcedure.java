package net.hanhai.titankillerneo.procedures;

import com.fasterxml.jackson.databind.ser.Serializers;
import net.hanhai.titankillerneo.TitankillerneoMod;
import net.minecraft.thetitans.entity.titan.BaseTitanEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.hanhai.titankillerneo.init.TitankillerneoModItems;

import javax.annotation.Nullable;

import static net.unknown5473.unknown5473lib.entity.UAnimatedEntity.DATA_new_health;

@EventBusSubscriber
public class WudiProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(),event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity,Entity sourceentity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
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