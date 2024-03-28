package net.vault.avalanche;

import net.fabricmc.api.ModInitializer;

import net.vault.avalanche.block.ModBlocks;
import net.vault.avalanche.item.ModItemGroup;
import net.vault.avalanche.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Avalanche implements ModInitializer {
	public static final String MOD_ID = "avalanche";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}