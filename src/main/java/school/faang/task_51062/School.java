package school.faang.task_51062;

import lombok.NonNull;

import java.util.List;

public record School(@NonNull String name, @NonNull List<Student> team) {
    public School {
        if (name.isBlank()) {
            throw new  IllegalArgumentException("Name cannot be blank");
        }
    }

    public int getTotalPoints() {
        return team.stream()
                .mapToInt(Student::getPoints)
                .sum();
    }

}
