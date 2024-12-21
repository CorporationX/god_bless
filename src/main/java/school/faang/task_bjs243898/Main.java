package school.faang.task_bjs243898;

public class Main {
    public static void main(String[] args) {
        Archer petr = new Archer("Petr");
        Warrior ivan = new Warrior("Ivan");
        System.out.println("здоровье ивана: " + ivan.health);
        System.out.println("петр атаковал ивана");
        petr.attack(ivan);
        System.out.println("здоровье ивана после атаки: " + ivan.health);
    }


}
