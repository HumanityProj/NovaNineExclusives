package net.gltched.n9_exclusives.item;

import net.gltched.n9_exclusives.NovaNineExclusives;
import net.minecraft.world.World;
import net.minecraft.util.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.entity.RenderSnowball;

import java.util.Random;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class GPGun {

    public GPGun() {
    }

    public static Item block;
    public static Object instance;

    public void load() {
        RenderingRegistry.registerEntityRenderingHandler(EntityArrowCustom.class, new RenderSnowball(NovaNineExclusives.galactic_bullet));

    }

    public void registerRenderers() {
    }

    public void generateNether(World world, Random random, int chunkX, int chunkZ) {
    }

    public void generateSurface(World world, Random random, int chunkX, int chunkZ) {
    }

    public int addFuel(ItemStack fuel) {
        return 0;
    }

    public void serverLoad(FMLServerStartingEvent event) {
    }

    public void preInit(FMLPreInitializationEvent event) {

        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(EntityArrowCustom.class, "entityBulletgpGun", entityID);
        EntityRegistry.registerModEntity(EntityArrowCustom.class, "entityBulletgpGun", entityID, instance, 64, 1, true);

    }

    static {
        block = (new ItemGPGun());
        Item.itemRegistry.addObject(423, "gpGun", block);
    }

    static class ItemGPGun extends Item {

        public ItemGPGun() {
            super();
            setMaxDamage(1200);
            maxStackSize = 1;
            setFull3D();
            setUnlocalizedName("gpGun");
            setTextureName("gpGun");
            setCreativeTab(CreativeTabs.tabCombat);
        }

        public int getMaxItemUseDuration(ItemStack par1ItemStack) {
            return 72000;
        }

        public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, final EntityPlayer par3EntityPlayer) {

            boolean flag = par3EntityPlayer.capabilities.isCreativeMode
                    || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;

            if (flag || par3EntityPlayer.inventory.hasItem(NovaNineExclusives.galactic_bullet)) {
                float f = 3.0F;

                EntityArrowCustom entityarrow = new EntityArrowCustom(par2World, par3EntityPlayer, f * 2.0F) {

                    public void onCollideWithPlayer(EntityPlayer entity) {
                        super.onCollideWithPlayer(entity);
                        int i = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
                        int j = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
                        int k = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
                        World world = this.worldObj;

                    }

                    public void onUpdate() {
                        super.onUpdate();
                        int i = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
                        int j = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
                        int k = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
                        World world = this.worldObj;
                        Entity entity = (Entity) par3EntityPlayer;

                        if (this.worldObj.getBlock(i, j, k) != Blocks.air || this.worldObj.getBlock(i, j - 1, k) != Blocks.air
                                || this.worldObj.getBlock(i, j + 1, k) != Blocks.air || this.worldObj.getBlock(i + 1, j, k) != Blocks.air
                                || this.worldObj.getBlock(i - 1, j, k) != Blocks.air || this.worldObj.getBlock(i, j, k + 1) != Blocks.air
                                || this.worldObj.getBlock(i, j, k - 1) != Blocks.air) {

                            this.kill();
                        }

                    }

                };

                entityarrow.setIsCritical(false);
                entityarrow.setDamage(300.0);
                entityarrow.setKnockbackStrength(1);

                if (false) {
                    entityarrow.setFire(100);
                }

                par1ItemStack.damageItem(1, par3EntityPlayer);
                // par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                if (flag) {
                    entityarrow.canBePickedUp = 2;
                } else {
                    par3EntityPlayer.inventory.consumeInventoryItem(Items.apple);
                }

                if (!par2World.isRemote) {
                    par2World.spawnEntityInWorld(entityarrow);
                }
                World world = par2World;
                EntityPlayer entity = par3EntityPlayer;
                int i = (int) entity.posX;
                int j = (int) entity.posY;
                int k = (int) entity.posZ;

            }

            return par1ItemStack;
        }

        /**
         * returns the action that specifies what animation to play when the
         * items is being used
         */
        public EnumAction getItemUseAction(ItemStack par1ItemStack) {
            return EnumAction.bow;
        }

    }

    public static class EntityArrowCustom extends EntityArrow {
        public EntityArrowCustom(World a) {
            super(a);
        }

        public EntityArrowCustom(World a, EntityLivingBase b, float c) {
            super(a, b, c);
        }
    }

}
