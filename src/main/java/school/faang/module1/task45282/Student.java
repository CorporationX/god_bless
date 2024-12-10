package school.faang.module1.task45282;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@EqualsAndHashCode
@ToString
public class Student {
    @EqualsAndHashCode.Exclude
    private int id;

    private String name;

    public Student(String name) {
        Random randomInt = new Random();
        this.id=randomInt.nextInt();
        this.name = name;
    }
}
