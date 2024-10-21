package distributed.army.homm;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Unit> units = new ArrayList<>();

        Object[][] unitParams = {{Archer.class, 25, 2}, {Swordsman.class, 50, 3}, {Mage.class, 75, 1}};
        for (Object[] parameter : unitParams) {
            addUnits(units, (Class<? extends Unit>) parameter[0], (int) parameter[1], (int) parameter[2]);
        }

        Army army = new Army(units);
        int totalPower = army.calculateTotalPower();
        System.out.println(totalPower);
    }

    private static void addUnits(List<Unit> targetList, Class<? extends Unit> unitClass, int power, int count) {
        for (int i = 0; i < count; i++) {
            try {
                targetList.add(unitClass.getDeclaredConstructor(int.class).newInstance(power));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
