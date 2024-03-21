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
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

@Mod(modid = NovaNineExclusives.MODID, version = NovaNineExclusives.VERSION)
public class NovaNineExclusives
{
    public static final String MODID = "n9_exclusives";
    public static final String VERSION = "1.0.0";

    ////////////////////////////////
    ///           ITEM           ///
    ////////////////////////////////
    public static Item feces;

    ////////////////////////////////
    ///          BLOCK           ///
    ////////////////////////////////
    public static Block gaslight;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Item/Block init and registration
        // Configuration Handler

        feces = new ItemFood(40, 1.0F, true).setUnlocalizedName("feces").setTextureName("n9_exclusives:feces");
        GameRegistry.registerItem(feces, feces.getUnlocalizedName().substring(5));

        gaslight = new Gaslight(Material.glass).setBlockName("gaslight_powered").setLightLevel(1.0F).setBlockTextureName("n9_exclusives:gaslight_powered");
        GameRegistry.registerBlock(gaslight, gaslight.getUnlocalizedName().substring(5));
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
