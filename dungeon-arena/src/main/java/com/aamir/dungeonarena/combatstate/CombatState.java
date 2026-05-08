package com.aamir.dungeonarena.combatstate;

/**
 * Represents a combat stance that changes how damage is received.
 */
public interface CombatState {

    /**
     * Calculates final damage based on the current combat state.
     */
    int calculateDamage(int incomingDamage);

    /**
     * Returns the name of the current combat state.
     */
    String getStateName();
}