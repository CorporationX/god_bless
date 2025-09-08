public class War {
    public static void main(String[] args) {
        Character warrior = new Warrior("Thorin");
        Character archer = new Archer("Legolas");

        System.out.println(warrior.getName() + " HP: " + warrior.getHealth()); // 100
        System.out.println(archer.getName() + " HP: " + archer.getHealth()); // 100

        warrior.attack(archer); // Воин наносит урон равный своей силе (10)
        System.out.println(archer.getName() + " HP после атаки: " + archer.getHealth()); // 90

        archer.attack(warrior); // Лучник наносит урон равный своей ловкости (10)
        System.out.println(warrior.getName() + " HP после атаки: " + warrior.getHealth()); // 90
    }
}
