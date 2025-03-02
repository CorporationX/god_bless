package bjs2_62337;

import java.util.List;

public record School(String name, List<Student> team) {
    public int getTotalPoints() {
        return team.stream().map(Student::getPoints).mapToInt(x -> x).sum();
    }
}
