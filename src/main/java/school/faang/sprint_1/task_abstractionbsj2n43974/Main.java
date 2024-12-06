package school.faang.sprint_1.task_abstractionbsj2n43974;

public class Main {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("warrior_soldier");
        Warrior warrior2 = new Warrior("warrior_soldier2", 20, 20, 20);
        Archer archer = new Archer("archer_Tom");

        for (int i = 0; i < 15; i++) {
            archer.attack(warrior);
            System.out.printf("%s attacks %s: remained health %d \n", archer.getName(), warrior.getName(), warrior.getHealth());
            if (warrior.getHealth() <= 0) {
                System.out.printf("%s is killed %n \n", warrior.name);
                break;
            }
        }


    }

}
