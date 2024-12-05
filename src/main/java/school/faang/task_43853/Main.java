package school.faang.task_43853;

public class Main {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("Ivan Zolo");
        Archer archer = new Archer("Fimozz");
        FightManager fightManager = FightManager.getInstance();

        fightManager.fight(warrior, archer);
    }
}
