package Sprint_3.BJS2_36019;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;

    public Person(String name, String surname, String workplace) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workplace = workplace;
    }

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
