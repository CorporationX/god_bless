package school.faang.bjs2_73979;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TamagotchiVlad {
    private String state = "Нейтральное";

    public synchronized void feed() {
        log.info("Влад ест");
        state = "Сытое";
    }

    public synchronized void play() {
        log.info("Влад играет");
        state = "Веселое";
    }

    public synchronized void clean() {
        log.info("Влад моется");
        state = "Чистое";
    }

    public synchronized void sleep() {
        log.info("Влад спит");
        state = "Выспавшееся";
    }
}