package school.faang.BJS2_85677;

public class Main {
    public static void main(String[] args) {
        //Test:
        Character petya = new Warrior("Петя мощный");
        Character vasya = new Archer("Вася меткий");
        for (int hit = 0; hit < 11; hit++) {
            petya.attack(vasya);
            vasya.attack(petya);
            System.out.println("Здоровье Васи: " + vasya.getHealth());
            System.out.println("Здоровье Пети: " + petya.getHealth());
        }
    }
}
