package school.faang.bjs250615;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Kingdom {

    private String name;

    public String sendMessage(Kingdom receiver) {
        try {
            Thread.sleep(5_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Could not deliver message from " + name + " to " + receiver.getName());
        }
        return "Message is successfully delivered from " + name + " to " + receiver.getName();
    }

}
