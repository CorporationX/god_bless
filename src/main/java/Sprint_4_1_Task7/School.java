package Sprint_4_1_Task7;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;
    public void getTotalPoints(){

    }
}
