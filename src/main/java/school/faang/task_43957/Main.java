package school.faang.task_43957;

public class Main {
    public static void main(String[] args) {
        Warrior viking = new Warrior("Viking", 12, 6, 15);
        System.out.println(viking);
        //Try to set illegal health value
        viking.setHealth(-100);
        System.out.println(viking);
        System.out.println();

        Warrior john = new Warrior("John");
        viking.attack(john);
        System.out.println(john);

        //Warrior attacks Archer
        Archer robin = new Archer("Robin");
        System.out.println(robin);
        while (robin.getHealth() >= 1) {
            john.attack(robin);
            System.out.println(robin.getHealth());
        }
        System.out.println(robin);
        System.out.println(john);
        System.out.println();

        //Archer attacks Warrior
        Archer elza = new Archer("Elza", 11, 17, 20);
        System.out.println(elza);
        while (john.getHealth() >= 1) {
            elza.attack(john);
            System.out.println(john.getHealth());
        }
        System.out.println(elza);
        System.out.println(john);
    }
}
