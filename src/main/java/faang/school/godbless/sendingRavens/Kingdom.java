package faang.school.godbless.sendingRavens;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Kingdom {
    private final String name;
    private final List<String> receivedMessages = new ArrayList<>();

    public Kingdom(String name) {
        this.name = name;
    }

    public synchronized void sendMessage(Kingdom kingdom, String message) {
        kingdom.getReceivedMessages().add(message);
    }
}
