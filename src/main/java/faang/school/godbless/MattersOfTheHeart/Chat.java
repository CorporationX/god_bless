package faang.school.godbless.MattersOfTheHeart;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@Getter
@RequiredArgsConstructor
public class Chat {
    private static final Random RANDOM = new Random();
    private final User firstUser;
    private final User secondUser;
    private boolean isGood = true;

    public void unlink() {
        System.out.printf("%s - %s -> ended not mutually\n", firstUser.getName(), secondUser.getName());
        firstUser.dislike(secondUser);
        secondUser.dislike(firstUser);
        isGood = false;
    }

    public void begin() {
        try {
            Thread.sleep(RANDOM.nextInt(3000, 6000));
            int result = RANDOM.nextInt(0, 2);
            if (result == 0) {
                unlink();
            } else {
                System.out.printf("%s - %s -> ended mutually\n", firstUser.getName(), secondUser.getName());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
