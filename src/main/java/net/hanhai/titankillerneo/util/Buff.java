package net.hanhai.titankillerneo.util;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Buff {
    private final List<Holder<MobEffect>> GoodBuff = Arrays.asList(
            MobEffects.HERO_OF_THE_VILLAGE,
            MobEffects.MOVEMENT_SPEED,
            MobEffects.DIG_SPEED,
            MobEffects.DAMAGE_BOOST,
            MobEffects.HEALTH_BOOST,
            MobEffects.JUMP,
            MobEffects.HEAL,
            MobEffects.REGENERATION,
            MobEffects.FIRE_RESISTANCE,
            MobEffects.WATER_BREATHING,
            MobEffects.INVISIBILITY,
            MobEffects.NIGHT_VISION,
            MobEffects.ABSORPTION,
            MobEffects.SATURATION,
            MobEffects.LUCK,
            MobEffects.CONDUIT_POWER,
            MobEffects.DOLPHINS_GRACE
    );

    private final List<Holder<MobEffect>> DeBuff = Arrays.asList(
            MobEffects.RAID_OMEN,
            MobEffects.MOVEMENT_SLOWDOWN,
            MobEffects.DIG_SLOWDOWN,
            MobEffects.WEAKNESS,
            MobEffects.WITHER,
            MobEffects.POISON,
            MobEffects.HARM,
            MobEffects.CONFUSION,
            MobEffects.FIRE_RESISTANCE,
            MobEffects.WATER_BREATHING,
            MobEffects.GLOWING,
            MobEffects.BLINDNESS,
            MobEffects.LEVITATION,
            MobEffects.HUNGER,
            MobEffects.UNLUCK,
            MobEffects.BAD_OMEN,
            MobEffects.DARKNESS
    );

    public void RemoveDebuff(LivingEntity livingEntity) {
        for (Holder<MobEffect> buff : this.DeBuff) {
            if (livingEntity.hasEffect(buff)) {
                livingEntity.removeEffect(buff);
            }
        }
    }

    public void GoodBuffToEver(LivingEntity livingEntity) {
        for (Holder<MobEffect> buff : this.GoodBuff) {
            if (livingEntity.hasEffect(buff) && !Objects.requireNonNull(livingEntity.getEffect(buff)).isInfiniteDuration()) {
                int level = Objects.requireNonNull(livingEntity.getEffect(buff)).getAmplifier();
                livingEntity.removeEffect(buff);
                livingEntity.addEffect(new MobEffectInstance(buff,-1,level));
            }
        }
    }

}
