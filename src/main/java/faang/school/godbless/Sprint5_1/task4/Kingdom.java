package faang.school.godbless.Sprint5_1.task4;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Kingdom {
    private String name;

    public String sendMessage(Kingdom kingdom) {
        return "Message from " + this.name + " to " + kingdom.name + " sent";
    }
}
