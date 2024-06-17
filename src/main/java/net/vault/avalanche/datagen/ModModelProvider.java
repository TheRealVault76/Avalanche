package net.vault.avalanche.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.vault.avalanche.block.ModBlocks;
import net.vault.avalanche.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ROUGH_PRODIUM_BLOCK);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ROUGH_PRODIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAKONIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_IRREGULARIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRREGULARIUM_BIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRREGULARIUM_CORE, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.IRREGULARIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.IRREGULARIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.IRREGULARIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.IRREGULARIUM_BOOTS));
    }
}
