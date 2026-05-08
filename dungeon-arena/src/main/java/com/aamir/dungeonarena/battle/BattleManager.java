package com.aamir.dungeonarena.battle;

import java.util.Random;
import java.util.Scanner;

import com.aamir.dungeonarena.characters.Enemy;
import com.aamir.dungeonarena.decorator.Combatant;
import com.aamir.dungeonarena.observer.BattleLogDisplay;
import com.aamir.dungeonarena.observer.GameModel;
import com.aamir.dungeonarena.observer.StatsDisplay;
import com.aamir.dungeonarena.combatstate.DefendingCombatState;
import com.aamir.dungeonarena.combatstate.NormalCombatState;

/**
 * Handles turn-based combat between the player and an enemy.
 * Manages player actions, enemy turns, and observer updates.
 */
public class BattleManager {

    private final Scanner scanner = new Scanner(System.in);
    private final GameModel gameModel;
    private final Random random;

    /**
     * Creates a BattleManager and registers observers.
     */
    public BattleManager() {
        gameModel = new GameModel();
        gameModel.addObserver(new StatsDisplay());
        gameModel.addObserver(new BattleLogDisplay());
        random = new Random();
    }

    /**
     * Runs a full battle until either the player or enemy is defeated.
     */
    public void startBattle(Combatant player, Enemy enemy, int round) {
        updateModel(player, enemy, round, "A wild " + enemy.getName() + " appears!");

        while (player.isAlive() && enemy.isAlive()) {
            playerTurn(player, enemy, round);

            if (enemy.isAlive()) {
                enemyTurn(player, enemy, round);
            }
        }

        if (player.isAlive()) {
            updateModel(player, enemy, round,
                    "Victory! You defeated the " + enemy.getName() + ".");
        } else {
            updateModel(player, enemy, round,
                    "Defeat... " + player.getName() + " has fallen.");
        }
    }

    /**
     * Handles the player's turn and chosen action.
     */
    private void playerTurn(Combatant player, Enemy enemy, int round) {
        System.out.println("Choose action:");
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Power Attack");

        int choice = readChoice();

        if (choice == 1) {
            int damage = player.attack();
            enemy.takeDamage(damage);
            updateModel(player, enemy, round,
                    player.getName() + " attacks " + enemy.getName() +
                            " for " + damage + " damage.");
        } else if (choice == 2) {
            player.setCombatState(new DefendingCombatState());
            updateModel(player, enemy, round,
                    player.getName() + " takes a defensive stance.");
        } else {
            performPowerAttack(player, enemy, round);
        }
    }

    /**
     * Executes a high-risk, high-damage power attack.
     */
    private void performPowerAttack(Combatant player, Enemy enemy, int round) {
        int hitChance = random.nextInt(100);

        if (hitChance < 70) {
            int damage = player.attack() + 10;
            enemy.takeDamage(damage);
            updateModel(player, enemy, round,
                    player.getName() + " lands a Power Attack on " +
                            enemy.getName() + " for " + damage + " damage.");
        } else {
            updateModel(player, enemy, round,
                    player.getName() + " uses Power Attack but misses.");
        }
    }

    /**
     * Handles the enemy's turn.
     */
    private void enemyTurn(Combatant player, Enemy enemy, int round) {
        int damage = enemy.attack();
        player.takeDamage(damage);

        updateModel(player, enemy, round,
                enemy.getAttackMessage() +
                        " It deals " + damage +
                        " damage to " + player.getName() + ".");

        player.setCombatState(new NormalCombatState());
    }

    /**
     * Reads and validates the player's action choice.
     */
    private int readChoice() {
        while (true) {
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                if (choice >= 1 && choice <= 3) {
                    return choice;
                }
            } else {
                scanner.next();
            }

            System.out.println("Invalid choice. Please enter 1, 2, or 3.");
        }
    }

    /**
     * Updates the observable model with latest battle data.
     */
    private void updateModel(Combatant player, Enemy enemy, int round, String message) {
        gameModel.updateStats(
                player.getName(),
                player.getHealth(),
                player.getMaxHealth(),
                enemy.getName(),
                enemy.getHealth(),
                enemy.getMaxHealth(),
                round,
                message);
    }
}