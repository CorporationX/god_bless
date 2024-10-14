package school.faangSprint2.t18;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> subjects;
}