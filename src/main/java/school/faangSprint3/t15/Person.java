package school.faangSprint3.t15;

import lombok.AllArgsConstructor;

@AllArgsConstructor
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
                ", workplace='" + workplace + '\'' +
                '}';
    }
}