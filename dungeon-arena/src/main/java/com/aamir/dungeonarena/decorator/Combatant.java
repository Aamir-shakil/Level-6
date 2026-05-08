package com.aamir.dungeonarena.decorator;

import com.aamir.dungeonarena.combatstate.CombatState;

/**
 * Represents any entity capable of participating in combat.
 * Used by the Decorator pattern to allow runtime behaviour modification.
 */
public interface Combatant {

    String getName();

    int getHealth();

    int getMaxHealth();

    int getAttackPower();

    CombatState getCombatState();

    void setCombatState(CombatState combatState);

    void setAttackPower(int attackPower);

    void takeDamage(int damage);

    void heal(int amount);

    boolean isAlive();

    int attack();
}