package faang.school.godbless.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.NoSuchElementException;

@Getter
@AllArgsConstructor
public class School {
    private List<Student> team;
    private String name;

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

    public Student getWinnerTeam() {
        int pointsWinner = team.stream()
                .mapToInt(Student::getPoints).max().orElseThrow(
                        () ->  new NoSuchElementException("No students found"));

        return team.stream()
                .filter(student -> student.getPoints() == pointsWinner)
                .findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException("No student with the highest points found"));
    }
}
