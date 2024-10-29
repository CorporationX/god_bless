package school.faang.sendraven;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Kingdom {
    private String name;

    public String sendMessage(Kingdom receiver) {
        Random random = new Random();
        boolean isMessageDelivered = random.nextBoolean();
        if (isMessageDelivered) {
            return "Message from the " + name + " to the " + receiver.getName() + " has been sent.";
        } else {
            return "The raven did not reach the " + receiver.getName();
        }
    }
}
