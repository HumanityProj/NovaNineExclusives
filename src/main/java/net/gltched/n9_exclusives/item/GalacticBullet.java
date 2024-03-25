package net.gltched.n9_exclusives.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.gltched.n9_exclusives.NovaNineExclusives;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

import java.util.List;

public class GalacticBullet extends Item {
    public GalacticBullet() {
        super();
        this.setCreativeTab(NovaNineExclusives.novaNineExclusiveTab);
        this.setTextureName("n9_exclusives:galactic_bullet");
        this.maxStackSize = 64;
    }
}
