package faang.school.godbless.finally_a_normal_game;

import lombok.SneakyThrows;
public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Ниф-ниф", "солома");
    }

    @Override
    @SneakyThrows
    public void run() {
        System.out.println(super.getPigName() + " начал строить дом из " + super.getMaterial());
        Thread.sleep(2000);
        System.out.println(super.getPigName() + " построил дом из " + super.getMaterial() + "!");

    }
}
