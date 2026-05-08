package com.aamir.dungeonarena.characters;

import java.util.Random;

/**
 * A stronger enemy type with higher health and attack power.
 */
public class Orc extends Enemy {

    private final Random random = new Random();
    private boolean heavySmashTriggered;

    public Orc() {
        super("Orc", 60, 18);
    }

    @Override
    public int attack() {
        heavySmashTriggered = random.nextInt(100) < 35;

        if (heavySmashTriggered) {
            return getAttackPower() + 10;
        }

        return getAttackPower();
    }

    @Override
    public String getAttackMessage() {
        if (heavySmashTriggered) {
            return getName() + " unleashes a Heavy Smash!";
        }

        return getName() + " swings its weapon.";
    }
}