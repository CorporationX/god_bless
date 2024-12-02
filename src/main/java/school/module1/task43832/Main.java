package school.module1.task43832;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Robin Hood");
        Warrior warrior = new Warrior("Konan");

        System.out.println(archer.getHealth());
        warrior.attack(archer);
        System.out.println(archer.getHealth());
    }
}
