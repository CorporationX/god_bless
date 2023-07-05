package faang.school.godbless.fourth.SendRaven;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class Kingdom {
    String name;
    List<String> messages = new ArrayList<>();
    int MAX_MESSAGE_LENGTH = 20;

    public String sendMessage(Kingdom kingdom, String message) {
        if (message.length() < MAX_MESSAGE_LENGTH) {
            kingdom.getMessage(message);
            return "The message successfully has been delivered";
        } else {
            throw new IllegalArgumentException("The message can't be that long");
        }
    }

    public void getMessage(String message) {
        messages.add(message);
    }
}
