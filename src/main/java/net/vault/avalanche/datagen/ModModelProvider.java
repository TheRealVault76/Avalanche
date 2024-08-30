package net.vault.avalanche.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.vault.avalanche.Avalanche;
import net.vault.avalanche.block.ModBlocks;
import net.vault.avalanche.block.custom.SuperCombinationStationBlock;
import net.vault.avalanche.block.enums.QuadBlockFlat;
import net.vault.avalanche.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRAGON_SCALE_BLOCK);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.SUPER_COMBINATION_STATION)
                .coordinate(BlockStateVariantMap.create(SuperCombinationStationBlock.PART, SuperCombinationStationBlock.FACING)
                        .register((QuadBlockFlat, direction) -> {
                            BlockStateVariant blockStateVariant = BlockStateVariant.create()
                                    .put(VariantSettings.MODEL, Identifier.of(Avalanche.MOD_ID, "block/super_combination_station_" + (QuadBlockFlat.ordinal() + 1)));
                            switch (direction) {
                                case SOUTH -> blockStateVariant.put(VariantSettings.Y, VariantSettings.Rotation.R180);
                                case WEST -> blockStateVariant.put(VariantSettings.Y, VariantSettings.Rotation.R270);
                                case EAST -> blockStateVariant.put(VariantSettings.Y, VariantSettings.Rotation.R90);
                                default -> {}
                            }
                            return blockStateVariant;
                        })
                )
        );


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.DRAGON_SCALE, Models.GENERATED);



    }
}
