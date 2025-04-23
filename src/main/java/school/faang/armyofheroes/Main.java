package school.faang.armyofheroes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // --- Test 1: single squad of three heroes ---
        Squad squad1 = new Squad(
                List.of(new Archer(), new Mage(), new Swordsman())
        );
        int expected1 = 25 + 50 + 25; // 100
        int actual1   = squad1.calculateSquadPower();
        System.out.printf("Test 1 - single squad: expected = %d, actual = %d%n", expected1, actual1);
        if (actual1 != expected1) {
            throw new AssertionError("Error calculating power of single squad");
        }

        // --- Test 2: multiple squads in the army under heavy load ---
        int iterations = 10;
        Army armyService = new Army(new ArrayList<>());


        for (int i = 0; i < iterations; i++) {
            armyService.addSquad(new Squad(List.of(new Archer(), new Archer())));         // 2 Archers → 50
            armyService.addSquad(new Squad(List.of(new Mage(), new Mage(), new Mage()))); // 3 Mages  → 150
            armyService.addSquad(new Squad(List.of(new Swordsman())));                    // 1 Swordsman → 25
        }

        // Expected power per one “triplet” of squads
        int perIteration = (2 * 25) + (3 * 50) + (25); // 50 + 150 + 25 = 225
        int expectedTotal = perIteration * iterations;    // 225 × 10 = 2250

        // Calculate actual total power
        long startTime = System.nanoTime();
        int actualTotal = armyService.calculateTotalPower();
        long durationMs = (System.nanoTime() - startTime) / 1_000_000;

        // Output results
        System.out.printf(
                "Heavy load calculation: expected total = %d, actual total = %d, time = %d ms%n",
                expectedTotal, actualTotal, durationMs
        );

        if (actualTotal != expectedTotal) {
            throw new AssertionError("Error calculating total army power under heavy load");
        }

        System.out.println("All tests passed successfully under heavy load!");
    }
}