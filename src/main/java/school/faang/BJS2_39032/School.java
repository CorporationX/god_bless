package school.faang.BJS2_39032;

import lombok.Data;
import java.util.List;

@Data
public class School {
    private String name;
    private List<Student> team;
    private int totalPoints = 0;

    public School(String name, List<Student> team) {
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints(){
        for(Student student : team) {
            totalPoints += student.getPoints();
        }
        return totalPoints;
    }
}
