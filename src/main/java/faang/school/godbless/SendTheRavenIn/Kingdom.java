package faang.school.godbless.SendTheRavenIn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.ThreadLocalRandom;

@ToString
@AllArgsConstructor
public class Kingdom {
    @Getter
    private String name;

    public void sendMessage(Kingdom otherKingdom) {
        System.out.printf("%s отправил сообщение\n", this.name);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
        } catch (InterruptedException e) {
            throw new RuntimeException("Ворон не вернулся");
        }
        System.out.printf("%s получил сообщение", otherKingdom.getName());
    }
}
