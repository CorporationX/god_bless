package school.faang.bjs243845;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("John");
        Warrior warrior  =new Warrior("Steve");

        archer.attack(warrior);
        archer.attack(warrior);
        warrior.attack(archer);
        warrior.attack(archer);

        System.out.println(warrior.getHealth());
        System.out.println(archer.getHealth());
    }
}
