package derschrank.sprint04.task03.bjstwo_51033;

import java.util.List;

public record School(
        String name,
        List<Student> team
) {
    public int getTotalPoints() {
        int result = 0;
        for (Student student : team) {
            result += student.getPoints();
        }
        return result;
    }

    public School updatePoints(Task task) {
        int reward = task.reward();
        team.forEach(x -> x.addPoints(reward));
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
