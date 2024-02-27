package star_wars_arena;

public class Main {
    public static void main(String[] args) {
        Robot robot1 = new Robot("Mark", 10, 5);
        Robot robot2 = new Robot("James", 6, 10);
        Battle fight = new Battle();

        fight.battle(robot1, robot2).thenAccept(winner -> {
            if (winner.isPresent()) {
                System.out.println("Победитель: " + winner.get().getName());
            } else {
                System.out.println("Ничья!");
            }
        }).join();
    }
}
