package net.hanhai.titankillerneo.mixin;

import net.hanhai.titankillerneo.init.TitankillerneoModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity{

    public LivingEntityMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Shadow
    public abstract float getHealth();

    @Inject(method = "setHealth",at = @At("HEAD"), cancellable = true)
    public void setHealth(float p_21154_, CallbackInfo ci){
        if (this.getPersistentData().getBoolean("wudi")) {
            if (p_21154_ < this.getHealth()) {
                ci.cancel();
            }
        }
    }
}
