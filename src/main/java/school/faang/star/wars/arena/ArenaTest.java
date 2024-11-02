package school.faang.star.wars.arena;

public class ArenaTest {
    static void getRandomValueTest(int p) {
        if ((0 > p || p >= 20)) { throw new AssertionError("Generated value is out of bounds"); }
        System.out.println("All tests has passed");
    }
}
