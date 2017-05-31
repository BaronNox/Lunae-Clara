package net.noxumbrarum.lunaeclara.blocks.json.blockstates;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import net.noxumbrarum.lunaeclara.References;

public class JsonSimpleBlockState
{
	@SuppressWarnings("unused")
	private int forge_marker;
	private JsonObject defaults;
	private JsonObject variants;
	
	public JsonSimpleBlockState(String name)
	{
		forge_marker = 1;
		
		defaults = new JsonObject();
		defaults.add("model", new JsonPrimitive(References.MODID + ":" + name));
		
		variants = new JsonObject();
		
		JsonArray normal = new JsonArray();
		normal.add(new JsonObject());
		
		JsonArray inventory = new JsonArray();
		inventory.add(new JsonObject());
		
		variants.add("normal", normal);
		variants.add("inventory", inventory);
	}		
}
