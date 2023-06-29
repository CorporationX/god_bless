package helping_colleague;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    String name;
    String surname;
    int age;
    String workplace;
}
