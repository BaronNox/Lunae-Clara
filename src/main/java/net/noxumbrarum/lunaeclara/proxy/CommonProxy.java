package net.noxumbrarum.lunaeclara.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.noxumbrarum.lunaeclara.LunaeClara;
import net.noxumbrarum.lunaeclara.client.gui.GuiHandlerLunaeClara;
import net.noxumbrarum.lunaeclara.hub.registries.ModBlocks;
import net.noxumbrarum.lunaeclara.hub.registries.ModItems;
import net.noxumbrarum.lunaeclara.misc.creativetabs.CreativeTabBlocks;

public class CommonProxy implements IProxyInits
{

	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		CreativeTabBlocks creativeTabModBlocks = CreativeTabBlocks.getInstance();
		
		ModBlocks.init();
		ModItems.init();
	}

	@Override
	public void init(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(LunaeClara.instance, new GuiHandlerLunaeClara());
	}

	@Override
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
