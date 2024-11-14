package school.faang.Diary;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> subjects;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
