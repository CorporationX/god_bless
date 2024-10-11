package school.faang.analysisOfUserActivity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
  private int userId;
  private String userName;
  private String actionType;
  private LocalDate actionDate;
  private String content;
}
