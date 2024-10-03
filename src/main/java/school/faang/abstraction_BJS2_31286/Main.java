package school.faang.abstraction_BJS2_31286;

public class Main {
    public static void main(String[] args) {
        Character archer = new Archer("Stepan");
        Character warrior = new Warrior("Ivan");
        Character warriorForStrike = new Warrior("Sufferer");

        warriorForStrike.showInfoAboutCharacterHealth();
        archer.attack(warriorForStrike);
        warriorForStrike.showInfoAboutCharacterHealth();
        warrior.attack(warriorForStrike);
        warriorForStrike.showInfoAboutCharacterHealth();
    }
}
