package school.faang.task_47642;



public class Main {

    public static void main(String[] args) throws InterruptedException {
        Army army = new Army();
        for (int i = 0; i < 10; i++) {
            army.addUnit(new Archer(25));
            army.addUnit(new Mage(50));
            army.addUnit(new Swordsman(75));
        }

        for (Thread thread : army.calculateTotalPower()){
            thread.start();
            thread.join();
        }

        System.out.println(army.getPowerArmy());
    }
}
