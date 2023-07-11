package faang.school.godbless.Sprint_5.Multithreading_Async.Raven;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Kingdom {
    private String name;

    public String sendMessage(Kingdom kingdom) {
        if (new Random().nextInt(0, 2) == 1) {
            throw new RuntimeException("Raven died(");
        }
        return "Message has been successfully delivered!";
    }
}
