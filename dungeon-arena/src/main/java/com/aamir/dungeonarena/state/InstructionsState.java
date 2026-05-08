package com.aamir.dungeonarena.state;

import java.util.Scanner;

import com.aamir.dungeonarena.main.Game;

/**
 * State that displays game instructions and controls.
 * Transitions to the battle state once the player is ready.
 */
public class InstructionsState implements GameState {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Displays instructions and waits for user input before starting the game.
     */
    @Override
    public void handle(Game game) {

        System.out.println("=================================");
        System.out.println("            HOW TO PLAY          ");
        System.out.println("=================================");
        System.out.println();

        System.out.println("You must defeat enemies in a turn-based battle.");
        System.out.println("Each round you face a stronger opponent.");
        System.out.println();

        System.out.println("Actions:");
        System.out.println("1. Attack        - Standard damage");
        System.out.println("2. Defend        - Reduce incoming damage");
        System.out.println("3. Power Attack  - High damage but may miss");
        System.out.println();

        System.out.println("After each victory you choose ONE buff:");
        System.out.println("- Strength Boost (+5 attack)");
        System.out.println("- Shield Boost (-5 damage taken)");
        System.out.println();

        System.out.println("Buffs remain active and can stack across rounds.");
        System.out.println();

        System.out.println("Press ENTER to start...");
        scanner.nextLine();
        scanner.nextLine();

        game.setState(new BattleState());
    }
}