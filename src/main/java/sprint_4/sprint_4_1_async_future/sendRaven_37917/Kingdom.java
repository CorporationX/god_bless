package sprint_4.sprint_4_1_async_future.sendRaven_37917;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kingdom {
    private final String name;

    public String sendMessage(Kingdom receiver) throws Exception {
        if (Math.random() < 0.25) {
            throw new Exception("The raven failed to deliver the message from " + name + " to " + receiver.getName());
        }
        return "The raven successfully delivered the message from " + name + " to " + receiver.getName();
    }
}
