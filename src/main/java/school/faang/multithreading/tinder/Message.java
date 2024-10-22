package school.faang.multithreading.tinder;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Message {

  private User user;
  private LocalDateTime dateTime;
  private String message;

}
