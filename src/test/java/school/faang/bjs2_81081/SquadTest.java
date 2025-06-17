package school.faang.bjs2_81081;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SquadTest {
    private final List<Archer> squad = List.of(new Archer(25), new Archer(30));
    private final Squad<Archer> archers = new Squad<>(squad);

    @Test
    void shouldCalculateSquadPower() {
        int expected = 0;
        for (Unit unit : squad) {
            expected += unit.getPower();
        }

        int actual = archers.calculateSquadPower();

        assertEquals(expected, actual);
    }
}