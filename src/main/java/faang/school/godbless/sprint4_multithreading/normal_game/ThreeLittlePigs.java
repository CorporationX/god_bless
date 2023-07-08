package faang.school.godbless.sprint4_multithreading.normal_game;

import lombok.SneakyThrows;
import java.util.List;

public class ThreeLittlePigs {
    @SneakyThrows
    public static void main(String[] args) throws InterruptedException {
        Pig1Thread pig1 = new Pig1Thread("Ниф-Ниф", 0);
        Pig2Thread pig2 = new Pig2Thread("Нуф-Нуф", 1);
        Pig3Thread pig3 = new Pig3Thread("Наф-Наф", 2);
        List<PigThread> pigs = List.of(pig1, pig2, pig3);
        pigs.forEach(Thread::start);
        pigs.forEach(Thread::join);
        }
    }

