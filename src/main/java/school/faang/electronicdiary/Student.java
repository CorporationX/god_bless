package school.faang.electronicdiary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Student {
    private String firstName;
    private String lastName;
    private Map<String, List<Integer>> subjects;
}
