package school.faang.task48100;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@Builder
public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final String workplace;
}
