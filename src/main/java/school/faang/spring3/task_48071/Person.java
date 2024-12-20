package school.faang.spring3.task_48071;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workPlace;

    @Override
    public String toString() {
        return "Person{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", workPlace='" + workPlace + '\''
                + '}';
    }
}
