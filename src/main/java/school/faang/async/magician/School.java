package school.faang.async.magician;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class School {

  private String name;
  private List<Student> team;

  public int getTotalPoints() {
    return team.stream()
        .mapToInt(Student::getPoints)
        .sum();
  }

  @Override
  public String toString() {
    return name;
  }
}
