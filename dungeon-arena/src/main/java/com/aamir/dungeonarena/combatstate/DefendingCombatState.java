package com.aamir.dungeonarena.combatstate;

/**
 * Defensive combat state where incoming damage is reduced by half.
 */
public class DefendingCombatState implements CombatState {

    @Override
    public int calculateDamage(int incomingDamage) {
        return incomingDamage / 2;
    }

    @Override
    public String getStateName() {
        return "Defending";
    }
}