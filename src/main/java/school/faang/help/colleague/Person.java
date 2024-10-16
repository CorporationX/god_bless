package school.faang.help.colleague;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;

    @Override
    public String toString() {
        return name + " " + surname + " " + age + " " + workplace;
    }
}
