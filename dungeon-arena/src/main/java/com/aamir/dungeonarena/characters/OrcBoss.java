package com.aamir.dungeonarena.characters;

import java.util.Random;

/**
 * A stronger late-game enemy with increased health and stronger heavy attacks.
 */
public class OrcBoss extends Enemy {

    private final Random random = new Random();
    private boolean heavySmashTriggered;

    public OrcBoss() {
        super("Orc Warlord", 60, 18);
    }

    @Override
    public int attack() {
        heavySmashTriggered = random.nextInt(100) < 40;

        if (heavySmashTriggered) {
            return getAttackPower() + 12;
        }

        return getAttackPower();
    }

    @Override
    public String getAttackMessage() {
        if (heavySmashTriggered) {
            return getName() + " unleashes a crushing war smash!";
        }

        return getName() + " hacks forward with brutal force.";
    }
}