package net.noxumbrarum.lunaeclara.blocks.json.models;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import net.noxumbrarum.lunaeclara.References;

public class JsonSimpleBlockModel
{
	@SuppressWarnings("unused")
	private JsonPrimitive parent;
	private JsonObject textures;
	
	public JsonSimpleBlockModel(String textureFileName)
	{
		parent = new JsonPrimitive("block/cube_all");
		textures = new JsonObject();
		textures.add("all", new JsonPrimitive(References.MODID +
				":" + "blocks/" + textureFileName));
	}
}
