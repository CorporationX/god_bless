package faang.school.godbless.async.sendRaven;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Kingdom {
    private String name;

    public String sendMessage(Kingdom otherKingdom){
        return name + " delivered the message to " + otherKingdom.name;
    }
}
