package faang.school.godbless.sprint4.raven;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kingdom {
    private String name;

    public void sendMessage(Kingdom kingdom, String message) {
        System.out.println(String.format("%s: was getting message %s", kingdom.getName(), message));
    }
}
