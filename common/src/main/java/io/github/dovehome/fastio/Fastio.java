package io.github.dovehome.fastio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.event.events.common.PlayerEvent;
import dev.architectury.platform.Platform;
import io.github.dovehome.fastio.config.FastConfig;
import net.minecraft.server.MinecraftServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Fastio
{
	public static final String MOD_ID = "fastio";
	public static final Path fastio = Platform.getConfigFolder().resolve(MOD_ID);
	public static final Path fastioJson = fastio.resolve("fastio.json");
	public static final Gson gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
	public static FastConfig fastConfig = FastConfig.DEFAULT;
	
	public static void init() {
		LifecycleEvent.SERVER_BEFORE_START.register(Fastio::stateChanged);
		PlayerEvent.PLAYER_JOIN.register(player -> {

		});
		PlayerEvent.PLAYER_QUIT.register(player -> {

		});
	}

	private static void stateChanged(MinecraftServer instance) {
		if (Files.exists(fastioJson)) {
			try (BufferedReader br = Files.newBufferedReader(fastioJson, StandardCharsets.UTF_8)) {
				fastConfig = gson.fromJson(br, FastConfig.class);
			} catch (IOException ignored) {}
			return;
		}
		if (!Files.exists(fastio)) {
			fastio.toFile().mkdirs();
		}
		try(BufferedWriter bw = Files.newBufferedWriter(fastioJson, StandardCharsets.UTF_8)) {
			bw.write(gson.toJson(fastConfig));
		} catch (IOException ignored) {}


	}
}
