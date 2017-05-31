package net.noxumbrarum.lunaeclara.blocks.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.noxumbrarum.lunaeclara.References;

public class CreateJson
{
	public static void createJsonBlock(String name) {
		Path path = Paths.get("..", "src", "main", "resources", "assets", References.MODID,
				"blockstates");
		
		if(Files.notExists(path, LinkOption.NOFOLLOW_LINKS)) {
			try
			{
				Files.createDirectories(path);
				Files.createFile(Paths.get(path.toString(), name + ".json"));
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println(path.toAbsolutePath());
		System.err.println("File exists");
	}
}
