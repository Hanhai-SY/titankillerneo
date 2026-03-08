package net.hanhai.titankillerneo.procedures;

import net.hanhai.titankillerneo.init.TitankillerneoModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.thetitans.entity.extra.EntityExperienceOrb;
import net.minecraft.thetitans.entity.extra.EntityItem;
import net.minecraft.thetitans.entity.titan.BaseTitanEntity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;

import static net.unknown5473.unknown5473lib.entity.UAnimatedEntity.DATA_new_health;

public class TitanKillerYouJiKongQiShiShiTiDeWeiZhiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        {
            Level level = entity.level();
            final Vec3 _center = new Vec3(x, y, z);
            for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(256 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
                if (entity != null) {
                    if (entityiterator != entity){
                        if (entity.isShiftKeyDown()) {
                            if ((entityiterator instanceof ItemEntity) || (entityiterator instanceof EntityItem) || (entityiterator instanceof EntityExperienceOrb) || (entityiterator instanceof ExperienceOrb)) {
                                if (entityiterator instanceof EntityItem || entityiterator instanceof EntityExperienceOrb) {
                                    entityiterator.hurt(new DamageSource(entity.level().holderOrThrow(DamageTypes.PLAYER_ATTACK), (Entity) entity), Float.POSITIVE_INFINITY);
                                }
                                entityiterator.push(entity.getX() - entityiterator.getX(), entity.getY() - entityiterator.getY(), entity.getZ() - entityiterator.getZ());
                            }
                        }else if (entityiterator instanceof BaseTitanEntity) {
                            BaseTitanEntity baseTitan = (BaseTitanEntity) entityiterator;
                            Float NewHealth = baseTitan.getEntityData().get(DATA_new_health);
                            if (NewHealth > 0.0f){
                                baseTitan.setHealth(0.0F);
                                baseTitan.getEntityData().set(DATA_new_health,0.0f);
                                baseTitan.killTitan();
                            }
                        } else if (!(entityiterator instanceof ItemEntity) && !(entityiterator instanceof EntityItem) && !(entityiterator instanceof EntityExperienceOrb) && !(entityiterator instanceof ExperienceOrb)) {
                            if (hasEntityInInventory(entityiterator, new ItemStack((ItemLike) TitankillerneoModItems.TITAN_KILLER.get()))) {
                                entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 0.0F);
                                continue;
                            }
                            entityiterator.setCustomName((Component)Component.literal("null"));
                            entityiterator.igniteForSeconds(999999.0F);
                            if (entityiterator instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity)entityiterator;
                                AttributeInstance _attrInst = _entity.getAttribute(Attributes.STEP_HEIGHT);
                                if (_attrInst != null)
                                    _attrInst.setBaseValue(0.10000000149011612D);
                            }
                            LivingEntity _livEnt = (LivingEntity)entity;
                            entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (entity instanceof LivingEntity) ? _livEnt.getMaxHealth() : -1.0F);
                            if (entityiterator instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity)entityiterator;
                                LivingEntity livingEntity1 = (LivingEntity)entity;
                                _entity.setHealth(((entity instanceof LivingEntity) ? livingEntity1.getHealth() : -1.0F) - 1024.0F);
                            }
                            if (entityiterator instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity)entityiterator;
                                LivingEntity livingEntity1 = (LivingEntity)entity;
                                _entity.setHealth((float)(((entity instanceof LivingEntity) ? livingEntity1.getHealth() : -1.0F) - Double.POSITIVE_INFINITY));
                            }
                            if (entityiterator instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity)entityiterator;
                                LivingEntity livingEntity1 = (LivingEntity)entity, livingEntity2 = (LivingEntity)entity;
                                _entity.setHealth(((entity instanceof LivingEntity) ? livingEntity1.getMaxHealth() : -1.0F) - ((entity instanceof LivingEntity) ? livingEntity2.getHealth() : -1.0F));
                            }
                            if (entityiterator instanceof LivingEntity) {
                                LivingEntity _entity = (LivingEntity)entityiterator;
                                _entity.setHealth(0.0F);
                            }
                            if (!entityiterator.isAttackable()) {
                                if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    LivingEntity livingEntity1 = (LivingEntity)entity;
                                    _entity.setHealth(((entity instanceof LivingEntity) ? livingEntity1.getMaxHealth() : -1.0F) - 1024.0F);
                                }
                                if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    LivingEntity livingEntity1 = (LivingEntity)entity;
                                    _entity.setHealth((float)(((entity instanceof LivingEntity) ? livingEntity1.getMaxHealth() : -1.0F) - Double.POSITIVE_INFINITY));
                                }
                            }
                            if (entityiterator.isInvulnerable()) {
                                if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    LivingEntity livingEntity1 = (LivingEntity)entity;
                                    _entity.setHealth(((entity instanceof LivingEntity) ? livingEntity1.getMaxHealth() : -1.0F) - 1024.0F);
                                }
                                if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    LivingEntity livingEntity1 = (LivingEntity)entity;
                                    _entity.setHealth((float)(((entity instanceof LivingEntity) ? livingEntity1.getMaxHealth() : -1.0F) - Double.POSITIVE_INFINITY));
                                }
                                if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    _entity.setHealth(-2.3564582E7F);
                                }
                            }
                            if (!entityiterator.level().isClientSide())
                                entityiterator.discard();
                            if (world instanceof ServerLevel) {
                                ServerLevel _level = (ServerLevel)world;
                                LightningBolt entityToSpawn = (LightningBolt) EntityType.LIGHTNING_BOLT.create((Level)_level, EntitySpawnReason.TRIGGERED);
                                entityToSpawn.moveTo(Vec3.atBottomCenterOf((Vec3i) BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));
                                _level.addFreshEntity((Entity)entityToSpawn);
                            }
                        }
                    }
                }
            }
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