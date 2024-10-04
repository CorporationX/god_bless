package school.faang.BJS2_31295;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Unreal strongman");
        Character archer = new Archer("Unreal sniper");

        while (warrior.health > 0 && archer.health > 0) {
            warrior.attack(archer);
            if (archer.health > 0)
                archer.attack(warrior);
        }
        System.out.println(warrior.health > 0
                ? "Победил воин, осталось здоровья " + warrior.health
                : "Победил лучник, осталось здоровья " + warrior.health);
    }
}