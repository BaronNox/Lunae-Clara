package net.noxumbrarum.lunaeclara.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.noxumbrarum.lunaeclara.hub.registries.ModBlocks;
import net.noxumbrarum.lunaeclara.misc.creativetabs.CreativeTabBlocks;

public class CommonProxy implements IProxyInits
{

	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		CreativeTabBlocks creativeTabModBlocks = CreativeTabBlocks.getInstance();
		
		ModBlocks.init();
	}

	@Override
	public void init(FMLInitializationEvent event)
	{
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
