package faang.school.godbless.colleagues;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Person {
    private String name;
    private String surname;
    private int age;
    private String workplace;

    public Person(int index){
        this.name = Integer.toString(index);
        this.surname = Integer.toString(index);
        this.workplace = Integer.toString(index);
        this.age = index;
    }
}
