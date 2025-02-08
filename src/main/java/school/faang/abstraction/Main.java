package school.faang.abstraction;

public class Main {

    public static void main(String[] args) {
        Warrior aleksei = new Warrior("Aleksei", 50, 2, 1);
        Archer logolas = new Archer("Logolas", 3, 50, 12);
        logolas.attack(aleksei);
        logolas.attack(aleksei);
        logolas.attack(aleksei);
        logolas.attack(aleksei);
        logolas.attack(aleksei);
        System.out.println(aleksei); //просто проверка на значение здоровья
    }
}
