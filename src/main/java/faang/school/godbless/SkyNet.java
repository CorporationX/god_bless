package faang.school.godbless;

import lombok.SneakyThrows;

public class SkyNet {
    @SneakyThrows
    public static void main(String[] args) {
        Robot Charlie = new Robot("Andrew");
        Robot Bob = new Robot("Fomas");

        new Thread(Charlie::attack).start();
        new Thread(Bob::attack).start();
        Thread.sleep(3);
        System.out.println("Done");
    }
}
