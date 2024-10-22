package turnir;

import java.util.List;

public class School {
    private String name;
    private List<Student> team;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public List<Student> getTeam() {
        return team;
    }

    public int getTotalPoints(Task task) {
        int totalPoints = 0;
        for (Student student : team) {
            totalPoints += student.updatePoints(task.getReward());
        }
        return totalPoints;
    }

}
