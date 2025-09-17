package school.faang.bjs2_89639;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily(
                List.of("Отремонтировать машину", "Поймать Воландеморта", "Познакомиться с Гермионой", "Спасти Гарри"));

        weasleyFamily.doTask();
    }
}
