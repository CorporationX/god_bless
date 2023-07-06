package faang.school.godbless.finally_a_normal_game;

import lombok.SneakyThrows;
public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Ниф-ниф", "солома", 2000);
    }

    @Override
    @SneakyThrows
    public void run() {
        super.run();
    }
}
