package faang.school.godbless.helpCollegue;

import lombok.Data;
import lombok.NonNull;

@Data
public class Person {
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private int age;
    @NonNull
    private String workPlace;
}
