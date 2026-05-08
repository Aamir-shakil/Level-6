package com.aamir.dungeonarena.decorator;

import com.aamir.dungeonarena.combatstate.CombatState;

/**
 * Base decorator class for modifying Combatant behaviour at runtime.
 * Delegates all calls to the wrapped combatant by default.
 */
public abstract class CharacterDecorator implements Combatant {

    protected Combatant wrappedCharacter;

    /**
     * Wraps a combatant to extend its behaviour.
     */
    public CharacterDecorator(Combatant wrappedCharacter) {
        this.wrappedCharacter = wrappedCharacter;
    }

    @Override
    public String getName() {
        return wrappedCharacter.getName();
    }

    @Override
    public int getHealth() {
        return wrappedCharacter.getHealth();
    }

    @Override
    public int getMaxHealth() {
        return wrappedCharacter.getMaxHealth();
    }

    @Override
    public int getAttackPower() {
        return wrappedCharacter.getAttackPower();
    }

    @Override
    public CombatState getCombatState() {
        return wrappedCharacter.getCombatState();
    }

    @Override
    public void setCombatState(CombatState combatState) {
        wrappedCharacter.setCombatState(combatState);
    }

    @Override
    public void setAttackPower(int attackPower) {
        wrappedCharacter.setAttackPower(attackPower);
    }

    @Override
    public void takeDamage(int damage) {
        wrappedCharacter.takeDamage(damage);
    }

    @Override
    public void heal(int amount) {
        wrappedCharacter.heal(amount);
    }

    @Override
    public boolean isAlive() {
        return wrappedCharacter.isAlive();
    }

    @Override
    public int attack() {
        return wrappedCharacter.attack();
    }
}