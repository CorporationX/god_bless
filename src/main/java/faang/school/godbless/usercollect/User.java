package faang.school.godbless.usercollect;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class User {

    private long id;
    private String name;
    private int age;
    private Set<String> activities;
}
