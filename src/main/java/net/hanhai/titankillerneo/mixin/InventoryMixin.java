package net.hanhai.titankillerneo.mixin;

import net.hanhai.titankillerneo.init.TitankillerneoModItems;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Inventory.class)
public class InventoryMixin {
    @Shadow
    @Final
    private List<NonNullList<ItemStack>> compartments;

    @Inject(method = "clearContent",at = @At("HEAD"), cancellable = true)
    public void clearContent(CallbackInfo ci) {
        System.out.println("1");
        for(List<ItemStack> list : this.compartments) {
            for (int i = 0; i < list.size() -1; i++) {
                if (list.get(i).getItem() == TitankillerneoModItems.TITAN_KILLER.get()) {
                    System.out.println("2");
                    ci.cancel();
                }
            }
        }
    }
}
