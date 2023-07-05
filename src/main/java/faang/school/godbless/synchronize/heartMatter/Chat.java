package faang.school.godbless.synchronize.heartMatter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class Chat {
    private User user1;
    private User user2;

    public void chattingStart() {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
