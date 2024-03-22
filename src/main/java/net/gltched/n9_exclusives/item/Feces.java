package net.gltched.n9_exclusives.item;

import net.minecraft.item.ItemFood;

public class Feces extends ItemFood {

    public Feces(int saturation, float satDuration, boolean alwaysEdible) {
        super(saturation, satDuration, alwaysEdible);
        this.setTextureName("n9_exclusives:poop");
    }
}