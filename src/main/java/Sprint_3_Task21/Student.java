package Sprint_3_Task21;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> courses;
}
