package school.faang.analysisOfUserActivity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
  private int id;
  private String name;
  private String email;
}
