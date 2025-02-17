package school.faang;

import lombok.ToString;

@ToString
public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final String workplace;

    public Person(String name, String surname, int age, String workplace) {
        validateString(name, "Name");
        validateString(surname, "Surname");
        validateString(workplace, "Workplace");

        this.name = name;
        this.surname = surname;
        this.age = age;
        this.workplace = workplace;
    }

    private void validateString(String name, String message) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(message + " can't be null or blank.");
        }
    }
}
