package school.faang.bsj2_56333;

public class RpgGam {
    public static void main(String[] args) {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        warrior.attack(archer);
        archer.attack(warrior);
    }
}