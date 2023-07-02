package faang.school.godbless.Sprint4.task5;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Army {
    private List<Unit> units;

    public String calculateTotalPower() {
        List<PowerThread> powerThreads = new ArrayList<>();
        for (Unit unit : units) {
            PowerThread powerThread = new PowerThread(unit);
            powerThreads.add(powerThread);
            powerThread.start();
        }

        for (PowerThread powerThread : powerThreads) {
            try {
                powerThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        int totalPower = 0;
        for (PowerThread powerThread : powerThreads) {
            System.out.println(powerThread.getNameUnit() + " has power - " + powerThread.getPower());
            totalPower += powerThread.getPower();
        }
        return "Total power - " + totalPower;
    }
}
