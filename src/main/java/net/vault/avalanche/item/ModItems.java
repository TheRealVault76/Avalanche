package net.vault.avalanche.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vault.avalanche.Avalanche;
import net.vault.avalanche.item.custom.IrregulariumArmorItem;

public class ModItems {

    public static final Item ROUGH_PRODIUM = registerItem("rough_prodium",
            new Item(new FabricItemSettings()));
    public static final Item DIAMOND_INGOT = registerItem("diamond_ingot",
            new Item(new FabricItemSettings()));
    public static final Item DRAKONIUM = registerItem("drakonium",
            new Item(new FabricItemSettings()));
    public static final Item RAW_IRREGULARIUM = registerItem("raw_irregularium",
            new Item(new FabricItemSettings()));
    public static final Item IRREGULARIUM_BIT = registerItem("irregularium_bit",
            new Item(new FabricItemSettings()));
    public static final Item IRREGULARIUM_CORE = registerItem("irregularium_core",
            new Item(new FabricItemSettings()));

    public static final Item IRREGULARIUM_HELMET = registerItem("irregularium_helmet",
            new IrregulariumArmorItem(ModArmorMaterials.IRREGULARIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item IRREGULARIUM_CHESTPLATE = registerItem("irregularium_chestplate",
            new IrregulariumArmorItem(ModArmorMaterials.IRREGULARIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item IRREGULARIUM_LEGGINGS = registerItem("irregularium_leggings",
            new IrregulariumArmorItem(ModArmorMaterials.IRREGULARIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item IRREGULARIUM_BOOTS = registerItem("irregularium_boots",
            new IrregulariumArmorItem(ModArmorMaterials.IRREGULARIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    private static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Avalanche.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Avalanche.LOGGER.info("Registering Mod Items for " + Avalanche.MOD_ID);
    }
}
