package faang.school.godbless.sprint1.vacancyAnalyzator;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Evgenii Malkov
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Job {
  private String position;
  private List<String> skills;
  private int salary;
  private String location;
  private LocalDate postedAt;
}
