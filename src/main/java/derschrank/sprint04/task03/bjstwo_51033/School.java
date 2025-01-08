package derschrank.sprint04.task03.bjstwo_51033;

import java.util.List;

public record School(
        String name,
        List<Student> team
) {
    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public School updatePoints(Task task) {
        int reward = task.reward();
        team.forEach(s -> s.addPoints(reward));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("School: ").append(name).append(" has total points: ").append(getTotalPoints()).append("\n");
        team.forEach(x -> result.append(" - ").append(x).append("\n"));
        return result.toString();
    }
}
