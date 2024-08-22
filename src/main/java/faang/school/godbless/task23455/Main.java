package faang.school.godbless.task23455;

public class Main {
    public static void main(String[] args) {
    Army army = new Army();
    army.addArcher(new Archer(50));
    army.addArcher(new Archer(50));
    army.addArcher(new Archer(50));
    army.addMage(new Mage(100));
    army.addSwordsman(new Swordsman(150));
    try {
        System.out.println(army.calculateTotalPower());
    } catch (InterruptedException e){
        e.printStackTrace();
    }
    }
}
