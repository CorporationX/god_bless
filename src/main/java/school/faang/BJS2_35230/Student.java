package school.faang.BJS2_35230;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> subjects;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
