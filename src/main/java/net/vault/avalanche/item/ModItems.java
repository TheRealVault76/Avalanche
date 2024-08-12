package net.vault.avalanche.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vault.avalanche.Avalanche;

public class ModItems {

    public static final Item DRAGON_SCALE = registerItem("dragon_scale",
            new Item(new FabricItemSettings()));





    private static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Avalanche.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Avalanche.LOGGER.info("Registering Mod Items for " + Avalanche.MOD_ID);
    }
}
