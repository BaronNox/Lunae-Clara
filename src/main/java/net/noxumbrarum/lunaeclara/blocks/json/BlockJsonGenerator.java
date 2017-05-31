package net.noxumbrarum.lunaeclara.blocks.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import net.noxumbrarum.lunaeclara.References;
import net.noxumbrarum.lunaeclara.blocks.json.blockstates.JsonSimpleBlockState;
import net.noxumbrarum.lunaeclara.blocks.json.models.JsonSimpleBlockModel;

public class BlockJsonGenerator
{
	public static void createJsons(String name) {
		createJsonBlockState(name);
		createJsonBlockModel(name);
	}
	
	public static void createJsonBlockState(String name) {
		Path path = Paths.get("..", "src", "main", "resources", "assets", References.MODID,
				"blockstates");
		
		Path filePath = Paths.get("..", "src", "main", "resources", "assets", References.MODID,
				"blockstates", name + ".json");
		
		if(Files.notExists(filePath, LinkOption.NOFOLLOW_LINKS)) {
			try
			{
				Files.createDirectories(path);
				Files.createFile(filePath);
			} catch(IOException e)
			{
				e.printStackTrace();
			}
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			try
			{
				Files.write(filePath, gson.toJson(new JsonSimpleBlockState(name)).getBytes());
			} catch(JsonIOException | IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void createJsonBlockModel(String name) {
		Path path = Paths.get("..", "src", "main", "resources", "assets", References.MODID,
				"models");
		
		Path filePath = Paths.get("..", "src", "main", "resources", "assets", References.MODID,
				"models", "block", name + ".json");
		
		if(Files.notExists(filePath, LinkOption.NOFOLLOW_LINKS)) {
			try
			{
				Files.createDirectories(path);
				Files.createFile(filePath);
			} catch(IOException e)
			{
				e.printStackTrace();
			}
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			try
			{
				Files.write(filePath, gson.toJson(new JsonSimpleBlockModel(name)).getBytes());
			} catch(JsonIOException | IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
