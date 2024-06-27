package faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_3_heroes;

import faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_3_heroes.units.Angel;
import faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_3_heroes.units.Archer;
import faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_3_heroes.units.Mag;
import faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_3_heroes.units.Swordman;
import faang.school.godbless.sprint_3.multithreading_parallelism_thread.task_3_heroes.units.Unit;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Army army = new Army();

        for (int i = 0; i < 10; i++) {
            Unit u = createUnit(rand.nextInt(1, 5));
            army.addUnit(u);
        }

        int totalPower = army.calculateTotalPower();
        System.out.println(totalPower);

    }

    private static Unit createUnit(int r) {
        return switch (r) {
            case 1 -> new Angel();
            case 2 -> new Archer();
            case 3 -> new Mag();
            default -> new Swordman();
        };
    }
}
