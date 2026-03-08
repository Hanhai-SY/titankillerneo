package net.hanhai.titankillerneo.mixin;

import com.mojang.authlib.GameProfile;
import net.hanhai.titankillerneo.init.TitankillerneoModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.attachment.AttachmentHolder;
import org.checkerframework.checker.units.qual.A;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow
    public abstract CompoundTag getPersistentData();

    @Inject(method = "discard",at = @At("HEAD"), cancellable = true)
    public final void discard(CallbackInfo ci) {
        if (this.getPersistentData().getBoolean("wudi")) {
            ci.cancel();
        }
    }

    @Inject(method = "kill" ,at = @At("HEAD"), cancellable = true)
    public void kill(ServerLevel p_376411_, CallbackInfo ci) {
        if (this.getPersistentData().getBoolean("wudi")) {
            ci.cancel();
        }
    }

    @Inject(method = "remove",at = @At("HEAD"), cancellable = true)
    public void remove(Entity.RemovalReason p_146834_, CallbackInfo ci) {
        if (this.getPersistentData().getBoolean("wudi")) {
            ci.cancel();
        }
    }
}
