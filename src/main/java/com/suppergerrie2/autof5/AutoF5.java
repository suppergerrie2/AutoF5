package com.suppergerrie2.autof5;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.suppergerrie2.autof5.AutoF5Config;

public class AutoF5 implements ClientModInitializer {
	public static final AutoF5Config CONFIG = AutoF5Config.createAndLoad();

	public static final String MOD_ID = "sautof5";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeClient() {

	}
}