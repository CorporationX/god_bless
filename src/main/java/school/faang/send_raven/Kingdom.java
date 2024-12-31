package school.faang.send_raven;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Kingdom {
    private final String name;

    public String sendMessage(Kingdom receiver) throws RuntimeException{
        if (Math.random() < 0.2) {
            throw new RuntimeException("Raven was lost, message didn't send!");
        }
        return "Message successfully delivered from " + name + " to " + receiver.getName();
    }
}
