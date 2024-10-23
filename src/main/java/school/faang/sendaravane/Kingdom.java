package school.faang.sendaravane;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Kingdom {
    private String name;

    public void sendMessage(Kingdom receiver) {
        System.out.println("Message sent from " + this.name + " to " + receiver.getName());
    }
}

