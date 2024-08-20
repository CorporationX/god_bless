package helping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    @NonNull
    private String name;
    @NonNull
    private String surname;
    private int age;
    @NonNull
    private String workplace;
}
