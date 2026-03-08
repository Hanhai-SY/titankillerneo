package net.hanhai.titankillerneo.item;

import net.hanhai.titankillerneo.init.TitankillerneoModItems;
import net.hanhai.titankillerneo.util.Buff;
import net.hanhai.titankillerneo.util.Color;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.thetitans.entity.extra.EntityExperienceOrb;
import net.minecraft.thetitans.entity.extra.EntityItem;
import net.minecraft.thetitans.entity.titan.BaseTitanEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.hanhai.titankillerneo.procedures.TitanKillerYouJiKongQiShiShiTiDeWeiZhiProcedure;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static net.unknown5473.unknown5473lib.entity.UAnimatedEntity.DATA_new_health;

public class TitanKillerItem extends SwordItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 2147483647, Float.POSITIVE_INFINITY, 0, 2147483647, TagKey.create(Registries.ITEM, ResourceLocation.parse("titankillerneo:titan_killer_repair_items")));

	public TitanKillerItem(Item.Properties properties) {
		super(TOOL_MATERIAL, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, properties);
	}


	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		TitanKillerYouJiKongQiShiShiTiDeWeiZhiProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		TitanKillerYouJiKongQiShiShiTiDeWeiZhiProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
        Level world = entity.level();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        Vec3 center = new Vec3(x, y, z);
        List<Entity> entfound = world.getEntitiesOfClass(Entity.class, (new AABB(center, center)).inflate(64.0D), e -> true).stream().sorted(Comparator.comparingDouble(entcnd -> entcnd.distanceToSqr(center))).toList();
        for (Entity entityiterator : entfound) {
            if (entity != entityiterator) {
                if (entityiterator instanceof BaseTitanEntity) {
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
                    entityiterator.push(entity.getX() - entityiterator.getX(),entity.getY() - entityiterator.getY(),entity.getZ() - entityiterator.getZ());
                }
            }
        }
		return true;
	}

    @Override
    public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.getAbilities().mayfly = true;
            player.onUpdateAbilities();
            player.getFoodData().setFoodLevel(500);
            player.getFoodData().setSaturation(500);

            if (player.getY() < -100.0D) {
                player.push(0.0D, 10.0D, 0.0D);
            }

            player.setHealth(player.getMaxHealth());
            if (!world.isClientSide()) {
                if (player instanceof LivingEntity) {
                    if (!((LivingEntity) player).hasEffect(MobEffects.ABSORPTION)) {
                        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, -1, 249, false, false));
                    }
                }
            }
            itemstack.setDamageValue(0);
            player.clearFire();
            entity.setAirSupply(300);
            entity.setSprinting(true);
            entity.setTicksFrozen(0);
            if (entity instanceof LivingEntity) {
                Buff buff = new Buff();
                buff.RemoveDebuff((LivingEntity) entity);
                buff.GoodBuffToEver((LivingEntity) entity);
            }
        }
    }

    @Override
    public Component getName(ItemStack stsck){
        return (Component)Component.translatable(Color.makeColour("神·木剑"));
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, context, list, flag);
        list.add(Component.translatable(Color.makeColour("由创世之初第一棵树的木头制成，沾染了创世神神力的它能斩断除了Notch以外的一切！")));
    }

    private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
        if (entity instanceof Player) {
            Player player = (Player)entity;
            return player.getInventory().contains(stack -> (!stack.isEmpty() && ItemStack.isSameItem(stack, itemstack)));
        }
        return false;
    }
}