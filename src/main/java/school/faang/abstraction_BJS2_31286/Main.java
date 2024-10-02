package school.faang.abstraction_BJS2_31286;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Stepan");
        Character warrior = new Warrior("Ivan");
        Character warriorForStrike = new Warrior("Sufferer");

        System.out.println(warriorForStrike.name + " health is " + warriorForStrike.health);
        archer.attack(warriorForStrike);
        System.out.println(warriorForStrike.name + " health is " + warriorForStrike.health);
        warrior.attack(warriorForStrike);
        System.out.println(warriorForStrike.name + " health is " + warriorForStrike.health);
    }
}
