package school.faang.task_56473;

public class Main {
    public static void main(String[] args) {

        Warrior aragorn = new Warrior("Аграном");
        Archer legolas = new Archer("Логовас");
        aragorn.attack(legolas);
        legolas.attack(aragorn);
        System.out.printf("Здоровье после обоюдной атаки составляет:\n%s: %d\n%s: %d ",
                legolas.getName(), legolas.getHealth(), aragorn.getName(), aragorn.getHealth());
    }
}

