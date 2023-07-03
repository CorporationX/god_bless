package tournament_among_kings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
@Getter
public class Trial  implements Runnable{
    private final String knightName;
    private final String trialName;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started trial " + trialName);
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " finished trial " + trialName);
    }
}
