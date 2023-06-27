package faang.school.godbless.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Pig2Thread extends PigThread {

    public Pig2Thread(String name, Material material) {
        super(name, material);
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(material.name + " надежный материал. Уйдет побольше времени");
        TimeUnit.SECONDS.sleep(5);
        System.out.println(name + " построил дом за 5 секунд");
    }
}
