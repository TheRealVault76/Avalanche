package net.vault.avalanche.item.client;

import net.vault.avalanche.item.custom.IrregulariumArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class IrregulariumArmorRenderer extends GeoArmorRenderer<IrregulariumArmorItem> {
    public IrregulariumArmorRenderer() {
        super(new IrregulariumArmorModel());
    }
}