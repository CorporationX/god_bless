package faang.school.godbless.BJS2_23405;

public class Main {
    public static void main(String[] args) {
        Army army = new Army();
        army.add(new Archer(), 10);
        army.add(new Swordman(), 20);
        army.add(new Mage(), 2);
        System.out.println("Total army: " + army.calculateTotalPower());
    }
}
