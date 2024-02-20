package org.rolypolyvole.seacreatures.creatures;

public enum Creature {
    LAKE_SQUID(1),
    PUFFERFISH_STACK(1);

    private final int weight;

    Creature(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
