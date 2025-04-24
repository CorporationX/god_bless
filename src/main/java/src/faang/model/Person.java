package src.faang.model;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final String workplace;
}
