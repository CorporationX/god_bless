package faang.school.godbless.sprint5.sendRaven.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class Kingdom {
    private String name;

    public String sendRaven(Kingdom kingdom) {
        if (new Random().nextInt() % 2 == 0) {
            throw new RuntimeException("Raven killed");
        }
        return "Raven successfully delivered to " + kingdom.name;
    }
}
