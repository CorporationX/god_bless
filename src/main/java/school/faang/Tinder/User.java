package school.faang.Tinder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class User {
  private int id;
  private String name;
  private boolean isOnline;
  private boolean isLookingForChat;
}
