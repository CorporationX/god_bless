package faang.school.godbless.JavaBeisic.BJS2_7165;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;
}
