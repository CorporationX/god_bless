package school.faang.task_43904;

public class Main {
    public static void main(String[] args) {
        Character hero1 = new Archer("Arnold Shwartz");
        Character hero2 = new Warrior("Silvester Stal");
        hero1.attack(hero2);
        hero2.attack(hero1);
    }
}
