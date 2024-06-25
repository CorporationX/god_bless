package faang.school.godbless.sprint1.socialNetwork;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Evgenii Malkov
 */
@Getter
@AllArgsConstructor
@ToString
public class UserAction {
  private long id;
  private String username;
  private ActionType actionType;
  private LocalDateTime actionDate;
  private String content;
}
