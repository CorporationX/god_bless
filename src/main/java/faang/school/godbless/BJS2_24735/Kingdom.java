package faang.school.godbless.BJS2_24735;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Kingdom {
    private final String name;

    public void sendMessage(Kingdom kingdom) {
        System.out.println(name + " sent " + kingdom.name + " message");
    }
}
