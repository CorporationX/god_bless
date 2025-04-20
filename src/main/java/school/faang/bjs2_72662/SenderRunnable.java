package school.faang.bjs2_72662;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SenderRunnable implements Runnable {
    private int startIndex;
    private int endIndex = 200;

    @Override
    public void run() {
        for (startIndex = 1; startIndex <= endIndex; startIndex++) {
            log.info("Поток {} отправил письмо номер {}", Thread.currentThread().getName(), startIndex);
        }
    }
}
