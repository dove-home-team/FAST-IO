package io.github.dovehome.fastio.fabric;

import io.github.dovehome.fastio.Fastio;
import net.fabricmc.api.ModInitializer;

public class FastioFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Fastio.init();
    }
}