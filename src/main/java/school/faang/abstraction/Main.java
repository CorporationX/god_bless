package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Archer archer = new Archer("Amanzhol");
        Warrior warrior = new Warrior("Diana");
        System.out.println(archer.getHp());
        System.out.println(warrior.getHp());
        archer.attack(warrior);
        System.out.println(archer.getHp());
        System.out.println(warrior.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        warrior.attack(archer);
        System.out.println(archer.getHp());
        archer.attack(warrior);
        System.out.println(warrior.getHp());
        archer.attack(warrior);
        System.out.println(warrior.getHp());
        archer.attack(warrior);
        System.out.println(warrior.getHp());
        archer.attack(warrior);
        System.out.println(warrior.getHp());
        archer.attack(warrior);
        System.out.println(warrior.getHp());
        archer.attack(warrior);
        System.out.println(warrior.getHp());
        archer.attack(warrior);
        System.out.println(warrior.getHp());
        archer.attack(warrior);
        System.out.println(warrior.getHp());
        archer.attack(warrior);
        System.out.println(warrior.getHp());
        archer.attack(warrior);
        System.out.println(warrior.getHp());
        archer.attack(warrior);
        System.out.println(warrior.getHp());
        Archer archer1 = new Archer("Misha");
        System.out.println(archer1.getHp());
        System.out.println(archer1.getAgility());
        System.out.println(archer1.getIntelligence());
        System.out.println(archer1.getStrength());
        Warrior warrior1 = new Warrior("Oleg");
        System.out.println(warrior1.getHp());
        System.out.println(warrior1.getAgility());
        System.out.println(warrior1.getIntelligence());
        System.out.println(warrior1.getStrength());





    }
}
