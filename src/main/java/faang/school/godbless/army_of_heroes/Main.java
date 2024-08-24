package faang.school.godbless.army_of_heroes;

import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Army army = new Army();

        army.addCharacter(new Archer(25));
        army.addCharacter(new Swordsman(40));
        army.addCharacter(new Mage(50));
        army.addCharacter(new Mage(20));

        int totalPower = army.calculateTotalPower();
        System.out.println("Total army power: " + totalPower);
    }
}
