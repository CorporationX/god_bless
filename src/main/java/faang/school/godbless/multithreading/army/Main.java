package faang.school.godbless.multithreading.army;

public class Main {

    public static void main(String[] args) {
        Army army = new Army();
        army.getHeroes().add(new Archer(25));
        army.getHeroes().add(new Swordsman(80));
        army.getHeroes().add(new Mage(50));
        army.getHeroes().add(new Mage(20));

        var totalPower = army.calculateTotalPower();
        System.out.println(totalPower);
    }
}
