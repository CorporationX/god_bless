package faang.school.godbless.help;

import lombok.Data;
import lombok.NonNull;


@Data
public class Person {
    @NonNull
    private String name;
    private String surname;
    private byte age;
    private String workplace;
}
