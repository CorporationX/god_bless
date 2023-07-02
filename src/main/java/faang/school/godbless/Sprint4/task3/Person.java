package faang.school.godbless.Sprint4.task3;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Getter
public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final String workplace;

    private static final List<String> nameList =
            Arrays.asList("John", "Muhammad", "James", "David", "Ana", "Mikhail", "Fatima", "Jose", "Maria", "Bob");
    private static final List<String> surnameList =
            Arrays.asList("Smith", "Lopez", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Garcia");
    private static final List<String> workplaceList =
            Arrays.asList("Facebook", "Apple", "Amazon", "Netflix", "Google", "Oracle", "Microsoft", "Tesla", "Intel", "NVIDIA");

    public Person() {
        this.name = nameList.get(new Random().nextInt(nameList.size()));
        this.surname = surnameList.get(new Random().nextInt(surnameList.size()));
        this.age = new Random().nextInt(83) + 18;
        this.workplace = workplaceList.get(new Random().nextInt(workplaceList.size()));
    }
}
