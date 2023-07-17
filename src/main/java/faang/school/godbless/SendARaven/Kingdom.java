package faang.school.godbless.SendARaven;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kingdom {
    private String name;

    public String sendMessage(Kingdom kingdom, String message) {
        if (message.toLowerCase().contains("poison")) {
            throw new IllegalArgumentException("Poisoned message");
        }
        return name + " sent raven to " + kingdom.getName();
    }
}
