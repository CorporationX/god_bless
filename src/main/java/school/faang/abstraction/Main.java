package school.faang.abstraction;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Connan!");
        Character archer = new Archer("Legolas!");

        warrior.attack(archer);
        System.out.println("У лучника после атаки воина осталось " + archer.health + " здоровья!");

        archer.attack(warrior);
        System.out.println("У воина после атаки лучника осталось " + warrior.health + " здоровья!");
    }
}
