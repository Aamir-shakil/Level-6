package com.aamir.dungeonarena.combatstate;

/**
 * Default combat state where full damage is taken.
 */
public class NormalCombatState implements CombatState {

    @Override
    public int calculateDamage(int incomingDamage) {
        return incomingDamage;
    }

    @Override
    public String getStateName() {
        return "Normal";
    }
}