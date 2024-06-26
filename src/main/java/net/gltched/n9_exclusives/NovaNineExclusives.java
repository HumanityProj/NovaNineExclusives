/* PROPERTY OF GLTCHED NETWORK
    Alteration of any internal files is prohibited.
 */

package net.gltched.n9_exclusives;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.gltched.n9_exclusives.item.*;
import net.gltched.n9_exclusives.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = NovaNineExclusives.MODID, version = NovaNineExclusives.VERSION)
public class NovaNineExclusives
{
    public static final String MODID = "n9_exclusives";
    public static final String VERSION = "1.0.0";

    ////////////////////////////////
    ///          WEAPONS         ///
    ////////////////////////////////

    public static final Item.ToolMaterial betaMaterial = EnumHelper.addToolMaterial("beta_material", 4, 800, 1.0F, 1196.0F, 0);
    public static final Item.ToolMaterial reapersMaterial = EnumHelper.addToolMaterial("reapers_material", 2, 1200, 1.3F, 33.2F, 1);

    ////////////////////////////////
    ///           ITEM           ///
    ////////////////////////////////
    public static Item beta_sword;
    public static GPGun gp_gun;
    public static Item galactic_bullet;
    public static Item reapers_staff;

    ////////////////////////////////
    ///          BLOCK           ///
    ////////////////////////////////
    public static Block gaslight;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Item/Block init and registration
        // Configuration Handler

        beta_sword = new BetaSword(betaMaterial).setUnlocalizedName("betaSword");
        gp_gun = new GPGun();
        galactic_bullet = new GalacticBullet().setUnlocalizedName("galacticBullet");
        reapers_staff = new ReapersStaff(reapersMaterial).setUnlocalizedName("reapersStaff");
        GameRegistry.registerItem(beta_sword, "betaSword");
        GameRegistry.registerItem(galactic_bullet, "galacticBullet");
        GameRegistry.registerItem(reapers_staff, "reapersStaff");

        gaslight = new Gaslight(Material.glass).setBlockName("gaslight_powered").setLightLevel(1.0F).setBlockTextureName("n9_exclusives:gaslight_powered");
        GameRegistry.registerBlock(gaslight, "gaslight");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // Proxy, TileEntity, Entity, GUI & Packet Registration
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    public static CreativeTabs novaNineExclusiveTab = new CreativeTabs("n9_exclusives_tab") {
        @Override
        public Item getTabIconItem() {
            return new ItemStack(gaslight).getItem();
        }
    };
}
