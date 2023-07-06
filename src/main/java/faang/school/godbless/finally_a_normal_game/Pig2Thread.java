package faang.school.godbless.finally_a_normal_game;

import lombok.SneakyThrows;

public class Pig2Thread extends PigThread{
    public Pig2Thread() {
        super("Нуф-Нуф", "палки", 4000);
    }

    @Override
    @SneakyThrows
    public void run() {
        super.run();
    }
}
