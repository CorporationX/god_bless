package school.faang.task_43957;

public class Main {
    public static void main(String[] args) {
        Warrior vlad = new Warrior("Vlad", 12, 6, 15);
        System.out.println(vlad);
        Archer elza = new Archer("Elza", 11, 17, 20);
        System.out.println(elza);
        Warrior john = new Warrior("John");
        System.out.println(john);
        Archer robin = new Archer("Robin");
        System.out.println(robin);
        while (robin.getHealth() >= 1) {
            john.attack(robin);
            System.out.println(robin.getHealth());
        }
        System.out.println(robin);
    }
}
