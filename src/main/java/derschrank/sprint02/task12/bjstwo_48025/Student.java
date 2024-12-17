package derschrank.sprint02.task12.bjstwo_48025;

import java.util.List;
import java.util.Map;

public record Student(
        String firstName,
        String lastName,
        Map<String, List<Integer>> subjects
) {
    @Override
    public String toString() {
        StringBuilder subjectsString = new StringBuilder("Subjects:");
        for (String key : subjects.keySet()) {
            subjectsString.append(" " + key);
            subjectsString.append(": " + subjects.get(key));
        }

        return firstName + " " + lastName + ". " + subjectsString + "\n";
    }
}
