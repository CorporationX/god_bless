package faang.school.godbless.sprint4.send_crow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Kingdom {
    private final String name;

    public String sendMessage(Kingdom anotherKingdom) throws InterruptedException{
        System.out.printf("Sending a raven from '%s' to '%s'%n", this.name, anotherKingdom.name);
        Thread.sleep(3000);
        return String.format("Raven delivered from '%s' to '%s'", this.name, anotherKingdom.name);
    }
}
