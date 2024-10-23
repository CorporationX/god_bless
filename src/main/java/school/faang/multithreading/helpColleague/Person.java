package school.faang.multithreading.helpColleague;

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
        return "Person: " +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", workplace='" + workplace;
    }
}
