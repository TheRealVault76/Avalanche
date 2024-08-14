package net.vault.avalanche.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum QuadBlockFlat implements StringIdentifiable {
    PART1("part1"),
    PART2("part2"),
    PART3("part3"),
    PART4("part4");

    private final String name;

    QuadBlockFlat(String name) {
        this.name = name;
    }

    @Override
    public String asString() {
        return this.name;
    }
}
