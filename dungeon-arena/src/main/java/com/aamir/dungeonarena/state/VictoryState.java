package com.aamir.dungeonarena.state;

import java.util.Scanner;

import com.aamir.dungeonarena.decorator.ShieldBoostDecorator;
import com.aamir.dungeonarena.decorator.StrengthBoostDecorator;
import com.aamir.dungeonarena.main.Game;

/**
 * State representing a successful round completion.
 * Allows the player to choose a temporary buff before the next round.
 */
public class VictoryState implements GameState {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Handles victory logic, buff selection, and progression to next round.
     */
    @Override
    public void handle(Game game) {
        System.out.println();
        System.out.println("=================================");
        System.out.println("Round Cleared");
        System.out.println("=================================");
        System.out.println("You won round " + game.getRound() + ".");

        if (game.getRound() >= 3) {
            System.out.println("You cleared the dungeon and defeated every enemy!");
            System.out.println(
                "Final HP: " + game.getActivePlayer().getHealth() + "/" +
                game.getActivePlayer().getMaxHealth()
            );
            game.stop();
            return;
        }

        System.out.println();
        System.out.println("Choose one buff:");
        System.out.println("1. Strength Boost (+5 attack)");
        System.out.println("2. Shield Boost (-5 incoming damage)");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();


        if (choice == 1) {
            game.setActivePlayer(
                new StrengthBoostDecorator(game.getActivePlayer())
            );
            System.out.println("Strength Boost applied.");
        } else {
            game.setActivePlayer(
                new ShieldBoostDecorator(game.getActivePlayer())
            );
            System.out.println("Shield Boost applied.");
        }

        game.nextRound();
        game.setState(new BattleState());
    }
}