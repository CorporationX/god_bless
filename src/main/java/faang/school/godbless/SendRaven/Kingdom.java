package faang.school.godbless.SendRaven;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kingdom {
    private String name;

    public String sendMessage(Kingdom kingdom) {
        return "Sending message from " + name + " to " + kingdom.getName();
    }
}
