package net.vault.avalanche.item.client;

import net.vault.avalanche.Avalanche;
import net.vault.avalanche.item.custom.IrregulariumArmorItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class IrregulariumArmorModel extends GeoModel<IrregulariumArmorItem> {
    @Override
    public Identifier getModelResource(IrregulariumArmorItem animatable) {
        return new Identifier(Avalanche.MOD_ID, "geo/irregularium_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(IrregulariumArmorItem animatable) {
        return new Identifier(Avalanche.MOD_ID, "textures/models/armor/irregularium_armor.png");
    }

    @Override
    public Identifier getAnimationResource(IrregulariumArmorItem animatable) {
        return new Identifier(Avalanche.MOD_ID, "animations/irregularium_armor.animation.json");
    }
}
