package net.vault.avalanche.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.CryingObsidianBlock;
import net.vault.avalanche.Avalanche;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vault.avalanche.block.custom.SuperCombinationStationBlock;

public class ModBlocks {
    public static final Block DRAGON_SCALE_BLOCK = registerBlock("dragon_scale_block",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));

    public static final Block SUPER_COMBINATION_STATION = registerBlock("super_combination_station",
            new SuperCombinationStationBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN).nonOpaque());


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Avalanche.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Avalanche.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Avalanche.LOGGER.info("Registering ModBlocks for " + Avalanche.MOD_ID);
    }
}
