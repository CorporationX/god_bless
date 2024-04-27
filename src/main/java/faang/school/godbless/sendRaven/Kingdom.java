package faang.school.godbless.sendRaven;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kingdom {
    private String name;

    public String getMessage(Kingdom kingdom) {
        return "Sending message from " + name + " to " + kingdom.getName();
    }
}
