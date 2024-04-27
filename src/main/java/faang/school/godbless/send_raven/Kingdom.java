package faang.school.godbless.send_raven;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Kingdom {
    private String name;

    public void sendMessage(Kingdom recipient) {
        System.out.println(this.name + " отправляет сообщение королевству " + recipient.getName());
    }
}
