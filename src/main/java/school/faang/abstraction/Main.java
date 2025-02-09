package school.faang.abstraction;

public class Main {

    public static void main(String[] args) {
        Warrior aleksei = new Warrior("Aleksei");
        Archer logolas = new Archer("Logolas");
        logolas.attack(aleksei);
        logolas.attack(aleksei);
        logolas.attack(aleksei);
        logolas.attack(aleksei);
        logolas.attack(aleksei);
        logolas.setHealth(-1);
        System.out.println(aleksei); //просто проверка на значение здоровья
    }
}
