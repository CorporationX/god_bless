package school.faang.bjs2_85531;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Archer archer = new Archer();


        Character defeat = new Warrior();
        defeat.battle();

        warrior.attack(archer);
        archer.attack(warrior);
    }
}
