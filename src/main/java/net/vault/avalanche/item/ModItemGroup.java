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
    public static final ItemGroup DRAGON_SCALE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Avalanche.MOD_ID, "dragon_scale_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.diamond_ingot_group"))
                    .icon(() -> new ItemStack(ModItems.DRAGON_SCALE)).entries((displayContext, entries) -> {

                        entries.add(ModItems.DRAGON_SCALE);
                        entries.add(ModBlocks.DRAGON_SCALE_BLOCK);


                    }).build());

    public static void registerItemGroups() {

    }
}

