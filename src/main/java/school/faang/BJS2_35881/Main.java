package school.faang.BJS2_35881;

import school.faang.BJS2_35881.characters.Archer;
import school.faang.BJS2_35881.characters.Mage;
import school.faang.BJS2_35881.characters.Swordsman;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnit(new Archer());
        army.addUnit(new Swordsman());
        army.addUnit(new Mage());
        army.addUnit(new Mage());

        System.out.println("Метод с созданием потоков вручную");
        int totalPower = army.calculateTotalPower();
        System.out.println("Общая сила армии: " + totalPower);

        System.out.println("Метод с использованием ExecutorService");
        int totalPower2 = army.calculateTotalPower2();
        System.out.println("Общая сила армии: " + totalPower2);
    }
}
