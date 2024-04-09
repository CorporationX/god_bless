public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Askold");
        Archer archer = new Archer("Konan-varvar");

        warrior.attack(archer);
        archer.attack(warrior);
    }
}
