package school.faang.parallelism_3_1.bjs2_72662;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex;

    @Override
    public void run() {
        for (int letterCount = startIndex; letterCount < endIndex; letterCount++) {
            log.info("Поток {} отправил письмо номер {}", Thread.currentThread().getName(), startIndex + 1);
            startIndex++;
        }
    }
}
