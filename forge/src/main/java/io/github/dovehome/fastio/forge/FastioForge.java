package io.github.dovehome.fastio.forge;

import dev.architectury.platform.forge.EventBuses;
import io.github.dovehome.fastio.Fastio;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Fastio.MOD_ID)
public class FastioForge {
    public FastioForge() {
		// Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Fastio.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Fastio.init();
    }
}