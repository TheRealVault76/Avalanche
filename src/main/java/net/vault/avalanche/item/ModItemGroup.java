package net.vault.avalanche.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.vault.avalanche.Avalanche;
import net.vault.avalanche.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup DIAMOND_INGOT_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Avalanche.MOD_ID, "diamond_ingot_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.diamond_ingot_group"))
                    .icon(() -> new ItemStack(ModItems.DIAMOND_INGOT)).entries((displayContext, entries) -> {

                        entries.add(ModItems.ROUGH_PRODIUM);
                        entries.add(ModBlocks.ROUGH_PRODIUM_BLOCK);
                        entries.add(ModItems.DIAMOND_INGOT);
                        entries.add(ModItems.DRAKONIUM);
                        entries.add(ModItems.RAW_IRREGULARIUM);
                        entries.add(ModItems.IRREGULARIUM_BIT);
                        entries.add(ModItems.IRREGULARIUM_CORE);

                        entries.add(ModItems.IRREGULARIUM_HELMET);
                        entries.add(ModItems.IRREGULARIUM_CHESTPLATE);
                        entries.add(ModItems.IRREGULARIUM_LEGGINGS);
                        entries.add(ModItems.IRREGULARIUM_BOOTS);


                    }).build());

    public static void registerItemGroups() {

    }
}
