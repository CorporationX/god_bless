package school.faang.bjs2_82810;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class School {
    private String name;
    private List<Student> studentList;

    public int getTotalPoints() {
        int result = 0;
        for (Student student : studentList) {
            result += student.getPoints();
        }
        return result;
    }
}
