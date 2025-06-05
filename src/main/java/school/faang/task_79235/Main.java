package school.faang.task_79235;

public class Main {
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("Pavel");
        Archer archer1 = new Archer("Igor");
        Warrior warrior2 = new Warrior("Katya");

        warrior1.attack(archer1);
        warrior2.attack(archer1);
        archer1.attack(warrior1);
        archer1.attack(warrior2);

        for (int i = 0; i < 20; i++){
            warrior1.attack(archer1);
        }
    }
}
