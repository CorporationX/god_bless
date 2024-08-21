package faang.school.godbless;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
public class UserAction {
    private int id;
    private String username;
    private String actionType;
    private LocalDate actionDate;
    private String content;

   public UserAction(int id, String username, String actionType, LocalDate actionDate, String content) {
       this.id = id;
       this.username = username;
       this.actionType = actionType;
       this.actionDate = actionDate;
       this.content = content;
   }
}
