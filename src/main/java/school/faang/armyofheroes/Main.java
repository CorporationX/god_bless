package school.faang.armyofheroes;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // --- Test 1: single squad of three heroes ---
        Squad<Hero> squad1 = new Squad<>(
                List.of(
                        new Archer(),    // power = 25
                        new Mage(),      // power = 50
                        new Swordsman()  // power = 25
                )
        );
        int expected1 = 25 + 50 + 25; // 100
        int actual1   = squad1.calculateSquadPower();
        System.out.printf("Test 1 - single squad: expected = %d, actual = %d%n", expected1, actual1);
        if (actual1 != expected1) {
            throw new AssertionError("Error calculating power of single squad");
        }

        // --- Test 2: multiple squads in the army ---
        // Archer squad: 2 Archers
        Squad<Archer> archers = new Squad<>(
                List.of(new Archer(), new Archer())
        );
        int expectedArchers = 2 * 25; // 50

        // Mage squad: 3 Mages
        Squad<Mage> mages = new Squad<>(
                List.of(new Mage(), new Mage(), new Mage())
        );
        int expectedMages = 3 * 50; // 150

        // Swordsman squad: 1 Swordsman
        Squad<Swordsman> swords = new Squad<>(
                List.of(new Swordsman())
        );
        int expectedSwords = 25; // 25

        Army armyService = new Army(
                List.of(archers, mages, swords)
        );

        int expectedTotal = expectedArchers + expectedMages + expectedSwords; // 225
        int actualTotal   = armyService.calculateTotalPower();
        System.out.printf("Test 2 - entire army: expected = %d, actual = %d%n", expectedTotal, actualTotal);
        if (actualTotal != expectedTotal) {
            throw new AssertionError("Error calculating total army power");
        }

        System.out.println("All tests passed successfully!");
    }
}