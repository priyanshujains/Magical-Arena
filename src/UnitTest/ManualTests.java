package UnitTest;

import Java.Battle;
import Java.Player;




//Manual testing because unit testing needs an external library
public class ManualTests {

    public static void main(String[] args) {
        testPlayerTakeDamage();
        testPlayerIsAlive();
        testRollDice();
        testDetermineFirstAttacker();
        testTakeTurn();
        System.out.println("All tests passed!");
    }

    static void testPlayerTakeDamage() {
        Player player = new Player("Java.Player A", 50, 5, 10);

        // Test reducing health
        player.takeDamage(20);
        if (player.getHealth() != 30) {
            throw new AssertionError("Failed: testPlayerTakeDamage - Health did not reduce correctly");
        }

        // Test health not going below zero
        player.takeDamage(40);
        if (player.getHealth() != 0) {
            throw new AssertionError("Failed: testPlayerTakeDamage - Health went below 0");
        }
    }

    static void testPlayerIsAlive() {
        Player player = new Player("Java.Player A", 50, 5, 10);

        // Test player alive
        if (!player.isAlive()) {
            throw new AssertionError("Failed: testPlayerIsAlive - Java.Player should be alive when health > 0");
        }

        // Test player dead
        player.takeDamage(50);
        if (player.isAlive()) {
            throw new AssertionError("Failed: testPlayerIsAlive - Java.Player should not be alive when health = 0");
        }
    }

    static void testRollDice() {
        Player player = new Player("Java.Player A", 50, 5, 10);

        // Roll the dice multiple times to ensure range
        for (int i = 0; i < 100; i++) {
            int roll = player.rollDice();
            if (roll < 1 || roll > 6) {
                throw new AssertionError("Failed: testRollDice - Dice roll out of bounds (1-6)");
            }
        }
    }

    static void testDetermineFirstAttacker() {
        Player playerA = new Player("Java.Player A", 50, 5, 10);
        Player playerB = new Player("Java.Player B", 100, 10, 5);
        Battle arena = new Battle(playerA, playerB);

        // Test first attacker when Java.Player A has less health
        if (!arena.determineFirstAttacker().equals(playerA)) {
            throw new AssertionError("Failed: testDetermineFirstAttacker - Java.Player A should attack first");
        }

        // Test first attacker when Java.Player B has less health
        playerA.takeDamage(10);
        playerB.takeDamage(90); // Now Java.Player B has less health
        if (!arena.determineFirstAttacker().equals(playerB)) {
            throw new AssertionError("Failed: testDetermineFirstAttacker - Java.Player B should attack first");
        }
    }

    static void testTakeTurn() {
        Player attacker = new Player("Java.Player A", 50, 5, 10);
        Player defender = new Player("Java.Player B", 100, 10, 5);
        Battle arena = new Battle(attacker, defender);

        // Take one turn and ensure defender's health reduces
        arena.takeTurn(attacker, defender);
        if (defender.getHealth() >= 100) {
            throw new AssertionError("Failed: testTakeTurn - Defender health did not reduce");
        }

        // Ensure health doesn't go negative
        defender.takeDamage(100);
        if (defender.getHealth() != 0) {
            throw new AssertionError("Failed: testTakeTurn - Health should not go below 0");
        }
    }
}
