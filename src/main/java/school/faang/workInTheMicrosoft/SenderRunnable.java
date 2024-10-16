package school.faang.workInTheMicrosoft;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SenderRunnable implements Runnable {
  private int startIndex;
  private int endIndex;
  private List<Message> messages;

  @Override
  public void run() {
    for (int i = startIndex; i <= endIndex; i++) {
      Message message = messages.get(i);
      System.out.printf("%s : %s\n", message.getTitle(), message.getContent());
    }
  }
}
