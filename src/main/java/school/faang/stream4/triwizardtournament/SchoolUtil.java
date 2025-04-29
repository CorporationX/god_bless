package school.faang.stream4.triwizardtournament;

import java.util.List;
import java.util.stream.IntStream;

public class SchoolUtil {
    public static void distributePoints(List<Student> team, int totalPoints) {
        int size = team.size();
        int base = totalPoints / size;
        int remainder = totalPoints % size;

        IntStream.range(0, size)
                .forEach(i -> team.get(i).addPointsAndReturn(base + (i < remainder ? 1 : 0)));
    }
}
