package school.faang.sprint_3.task_bjs247927;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Unit> units = TestDataGenerator.createUnits(4);
        System.out.println(units);

        Army army = new Army(units);
        System.out.println("Total Army power: " + army.calculateTotalPower());
    }
}
