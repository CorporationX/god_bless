package faang.school.godbless.bjs2_9961;

import java.util.Arrays;
import java.util.List;

public class Main {

  private static final int MIN_LENGTH_MESSAGE = 15;
  private static final String MESSAGE = "Сообщение: ";
  private static final String MISSED = " | Пропущено: ";

  public static void main(String[] args) {

    MessageProcessor messageProcessor = new MessageProcessor();

    MessageFilter spamFilter = message -> !message.toLowerCase().contains("spam");
    MessageFilter lengthFilter = message -> message.length() > MIN_LENGTH_MESSAGE;
    MessageFilter emojiFilter = message -> !message.contains(":)");

    List<MessageFilter> filters = List.of(spamFilter, lengthFilter, emojiFilter);

    String[] message = {"Hello!", "this is spam!", "What's up? :)", "Long message without spom and emoji"};

    Arrays.stream(message)
        .forEach(msg -> System.out.println(MESSAGE + msg + MISSED +
            messageProcessor.processMessage(msg, filters)));
  }

}
