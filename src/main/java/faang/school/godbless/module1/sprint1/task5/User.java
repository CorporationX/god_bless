package faang.school.godbless.module1.sprint1.task5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class User {
    private Long id;
    private String name;
    private int age;
    private Set<String> hobbies;


}
