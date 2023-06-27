package faang.school.godbless.finally_a_normal_game;

import lombok.SneakyThrows;

public class Pig2Thread extends PigThread{
    public Pig2Thread() {
        super("Нуф-Нуф", "палки");
    }

    @Override
    @SneakyThrows
    public void run() {
        System.out.println(super.getPigName() + " начал строить дом из " + super.getMaterial());
        Thread.sleep(3000);
        System.out.println(super.getPigName() + " построил дом из " + super.getMaterial() + "!");

    }
}
