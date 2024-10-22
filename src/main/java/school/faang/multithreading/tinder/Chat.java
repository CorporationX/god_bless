package school.faang.multithreading.tinder;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Chat {

  private User user1;
  private User user2;
  private List<Message> messages = new ArrayList<>(); // можно пока без обмена сообщений, по задаче пока не надо

}
