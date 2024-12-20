package school.faang.bjs248033;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final String workspace;
}