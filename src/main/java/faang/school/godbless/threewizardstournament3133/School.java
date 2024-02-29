package faang.school.godbless.threewizardstournament3133;

import lombok.Getter;

import java.util.List;

@Getter
public class School {
    private String name;
    private List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return this.getTeam().stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    @Override
    public String toString() {
        return String.format("""
                        %s
                        Team: %s
                        Total points: %d"""
                , this.getName(), this.getTeam(), this.getTotalPoints());
    }
}
