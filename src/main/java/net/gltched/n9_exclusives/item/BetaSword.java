package net.gltched.n9_exclusives.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.gltched.n9_exclusives.NovaNineExclusives;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.StatCollector;

import java.util.List;

public class BetaSword extends ItemSword {

    public BetaSword(ToolMaterial material) {
        super(material);
        this.setCreativeTab(NovaNineExclusives.novaNineExclusiveTab);
        this.setTextureName("n9_exclusives:betaSword");
        this.maxStackSize = 1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        super.addInformation(itemStack, player, list, par4);
        list.add(StatCollector.translateToLocal(getUnlocalizedName() + ".tooltip0"));
        list.add(StatCollector.translateToLocal(getUnlocalizedName() + ".tooltip1"));
        list.add(StatCollector.translateToLocal(getUnlocalizedName() + ".tooltip2"));
    }
}
