package net.noxumbrarum.lunaeclara.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.noxumbrarum.lunaeclara.hub.registries.ModBlocks;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		super.preInit(event);
		ModBlocks.secondBlock.initModel();
	}
}
