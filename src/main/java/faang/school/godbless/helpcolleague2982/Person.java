package faang.school.godbless.helpcolleague2982;

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
        return String.format("%s %s %d y.o. Works in %s",
                this.getName(),
                this.getSurname(),
                this.getAge(),
                this.getWorkplace());
    }
}
