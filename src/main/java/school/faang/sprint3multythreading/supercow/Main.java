package school.faang.sprint3multythreading.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(4);

        List<Thread> threads = IntStream.rangeClosed(1, 5)
                .mapToObj(k -> new Thread(()
                        -> new Player(String.format("Iгрок №%d", k))
                        .doBattle(boss)))
                .toList();
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                log.error("Прерывание, при ожидании потоков");
            }
        }
        log.info("Босс повержен!!!");
    }
}