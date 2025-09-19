package school.faang.bjs2_89657;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@ToString
@Slf4j
public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final String workplace;

}
