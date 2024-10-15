package school.faang.helpcolleague;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private Integer age;
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
