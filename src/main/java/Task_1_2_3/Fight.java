package Task_1_2_3;

public class Fight {
    public static void main(String[] args) {
        Character w = new Warrior("Thorin");
        Character a = new Archer("Legolas");

        System.out.println(w.getName() + " HP: " + w.getHealth()); // 100
        System.out.println(a.getName() + " HP: " + a.getHealth()); // 100

        w.attack(a); // Воин наносит урон равный своей силе (10)
        System.out.println(a.getName() + " HP после атаки: " + a.getHealth()); // 90

        a.attack(w); // Лучник наносит урон равный своей ловкости (10)
        System.out.println(w.getName() + " HP после атаки: " + w.getHealth()); // 90
    }
}
