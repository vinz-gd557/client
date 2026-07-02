package com.vinzclient;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VinzClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("vinzclient");
    public static final String NAME = "Vinz Client";

    @Override
    public void onInitializeClient() {
        LOGGER.info("Vinz Client initialized! Press Right-Shift to open the menu.");
    }
}
