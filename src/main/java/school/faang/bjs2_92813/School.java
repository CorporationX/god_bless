package school.faang.bjs2_92813;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class School {
    private String name;
    @Getter
    private List<Student> team;

    public int getTotalPoints() {
        int total = 0;
        for (Student member : team) {
            total += member.getPoints();
        }
        return total;
    }
}
