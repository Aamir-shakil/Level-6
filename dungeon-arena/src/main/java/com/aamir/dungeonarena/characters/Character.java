package com.aamir.dungeonarena.characters;

import com.aamir.dungeonarena.combatstate.CombatState;
import com.aamir.dungeonarena.combatstate.NormalCombatState;
import com.aamir.dungeonarena.decorator.Combatant;

/**
 * Abstract base class for all combat characters.
 * Provides shared health, attack, and combat state behaviour.
 */
public abstract class Character implements Combatant {

    private String name;
    private int maxHealth;
    private int health;
    private int attackPower;
    private CombatState combatState;

    public Character(String name, int maxHealth, int attackPower) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackPower = attackPower;
        this.combatState = new NormalCombatState();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public CombatState getCombatState() {
        return combatState;
    }

    @Override
    public void setCombatState(CombatState combatState) {
        this.combatState = combatState;
    }

    @Override
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public void takeDamage(int damage) {
        int finalDamage = combatState.calculateDamage(damage);
        health -= finalDamage;

        if (health < 0) {
            health = 0;
        }
    }

    @Override
    public void heal(int amount) {
        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public int attack() {
        return attackPower;
    }

    @Override
    public String toString() {
        return name + " | HP: " + health + "/" + maxHealth + " | ATK: " + attackPower;
    }
}