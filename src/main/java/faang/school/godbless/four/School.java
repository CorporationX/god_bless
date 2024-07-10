package faang.school.godbless.four;

import lombok.Getter;

import java.util.List;

public class School {
    private String name;
    @Getter
    private List<Student> team;

    public School(String name, List<Student> team) {
        if (name == null) {
            throw new IllegalArgumentException("In constructor School class apply is null String name");
        }
        if (team == null || team.isEmpty()) {
            throw new IllegalArgumentException("In constructor School class apply is empty or null List");
        }
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(student -> student.getPoint())
                .reduce(0, Integer::sum);
    }
}
