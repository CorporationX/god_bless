package faang.school.godbless.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Pig1Thread extends PigThread {

    public Pig1Thread(String name, Material material) {
        super(name, material);
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(material.name + " легкий материал. Я быстро построю дом");
        TimeUnit.SECONDS.sleep(2);
        System.out.println(name + " построил дом за 2 секунды");
    }
}
