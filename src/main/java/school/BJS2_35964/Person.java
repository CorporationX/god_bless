package school.BJS2_35964;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person {

    private String name;
    private String surname;
    private int age;
    private String workplace;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", workplace='" + workplace + '\'' +
                '}';
    }
}