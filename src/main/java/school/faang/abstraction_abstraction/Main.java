package school.faang.abstraction_abstraction;

public class Main    {
    public static void main(String[] args) {
        school.faang.abstraction_abstraction.Character archer = new Archer("archer");
        school.faang.abstraction_abstraction.Character warrior = new Warrior("warrior");

        System.out.println("warrior strength = " + warrior.getStrength());
        System.out.println("archer agility = " + archer.getAgility());
        System.out.println("fight...");

        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println("archer health = " + archer.getHealth());
        System.out.println("warrior health = " + warrior.getHealth());
    }
}
