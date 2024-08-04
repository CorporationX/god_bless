package faang.school.godbless.bjs218291;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@ToString
public class Student {
    String name;
    String faculty;
    int year;
}
