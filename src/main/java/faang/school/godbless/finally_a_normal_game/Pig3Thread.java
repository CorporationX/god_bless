package faang.school.godbless.finally_a_normal_game;

import lombok.SneakyThrows;

public class Pig3Thread extends PigThread{
    public Pig3Thread() {
        super("Наф-Наф", "кирпичи");
    }

    @Override
    @SneakyThrows
    public void run() {
        System.out.println(super.getPigName() + " начал строить дом из " + super.getMaterial());
        Thread.sleep(5000);
        System.out.println(super.getPigName() + " построил дом из " + super.getMaterial() + "!");

    }
}
