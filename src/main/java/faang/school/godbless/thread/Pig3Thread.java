package faang.school.godbless.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String name, Material material) {
        super(name, material);
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(material.name + " - это на века!. Нужно попотеть, но потом никакой волк не страшен!");
        TimeUnit.SECONDS.sleep(10);
        System.out.println(name + " построил дом за 10 секунд");
    }
}
