package faang.school.godbless.vedmak_and_monsters;

import lombok.AllArgsConstructor;

import java.util.List;

import static faang.school.godbless.vedmak_and_monsters.TimeUtils.secondElapsedTime;


@AllArgsConstructor
public class CityWorker implements Runnable {

    private List<Monster> monsters;
    private City city;

    @Override
    public void run() {
        long startTime = System.nanoTime();
        try {
            //ToDo реализовать логику обработки одного города,
            // пока эмулирую задержку при расчетах
            Thread.sleep((long) (Math.random() * 10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endTime = System.nanoTime();
        double total = secondElapsedTime(startTime, endTime);
        System.out.println("Hunted monsters in the city " + city.getName() +
                ". Wasted time " + total + " seconds");

    }
}


