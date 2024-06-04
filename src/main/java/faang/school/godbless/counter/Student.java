package faang.school.godbless.counter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Evgenii Malkov
 */
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class Student {
  private String name;
  private String faculty;
  private int year;
}
