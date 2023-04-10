package net.patchoulibutton;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.patchoulibutton.config.PatchouliButtonConfig;
import net.patchoulibutton.network.PatchouliButtonServerPacket;

public class PatchouliButton implements ModInitializer {

    public static final Identifier PATCHOULI_BUTTON = new Identifier("patchoulibutton", "textures/gui/patchouli_button.png");

    public static PatchouliButtonConfig CONFIG = new PatchouliButtonConfig();

    public static final boolean isBYGLoaded = FabricLoader.getInstance().isModLoaded("byg");

    @Override
    public void onInitialize() {
        AutoConfig.register(PatchouliButtonConfig.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(PatchouliButtonConfig.class).getConfig();
        PatchouliButtonServerPacket.init();
    }

}
