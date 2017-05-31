package net.noxumbrarum.lunaeclara;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.noxumbrarum.lunaeclara.proxy.CommonProxy;

@Mod(modid = References.MODID, name = References.NAME, version = "0.0.0", useMetadata = true)
public class LunaeClara
{
	@SidedProxy(clientSide = "net.noxumbrarum.lunaeclara.proxy.ClientProxy", serverSide = "net.noxumbarum.lunaeclara.proxy.ServerProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static LunaeClara instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}
