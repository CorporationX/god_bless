package faang.school.godbless.multithreading.triwizardtournament;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class School {
    private final String name;
    private final List<Student> students;
    private int rewardPointsForCompletedTasks;

    public int getTotalPoints(){
        return rewardPointsForCompletedTasks + students.stream()
                .mapToInt(Student::points)
                .sum();
    }
}
