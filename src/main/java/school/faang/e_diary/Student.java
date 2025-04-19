package school.faang.e_diary;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String lastName;
    private Map<String, List<Integer>> marks;
}
