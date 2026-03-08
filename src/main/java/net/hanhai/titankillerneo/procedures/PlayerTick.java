package net.hanhai.titankillerneo.procedures;

import net.hanhai.titankillerneo.init.TitankillerneoModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PlayerTick {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        execute((Event) event, (Entity) event.getEntity());
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;
        if (hasEntityInInventory(entity,new ItemStack(TitankillerneoModItems.TITAN_KILLER.get()))) {
            entity.getPersistentData().putBoolean("wudi",true);
        }else{
            entity.getPersistentData().putBoolean("wudi",false);
        }
    }

    private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
        if (entity instanceof Player) {
            Player player = (Player)entity;
            return player.getInventory().contains(stack -> (!stack.isEmpty() && ItemStack.isSameItem(stack, itemstack)));
        }
        return false;
    }
}