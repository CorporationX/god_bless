package school.faang.Mnogopotochka.Synhronaized.BJS2_36782;

public class Main {
    public static void main(String[] args) {
        Boss dragon = new Boss(3);

        Player dima = new Player("Dima", dragon);
        Player alex = new Player("Alex", dragon);
        Player maria = new Player("Maria", dragon);
        Player john = new Player("John", dragon);
        Player sophia = new Player("Sophia", dragon);
        Player michael = new Player("Michael", dragon);
        Player emma = new Player("Emma", dragon);
        Player daniel = new Player("Daniel", dragon);
        Player olivia = new Player("Olivia", dragon);
        Player james = new Player("James", dragon);
        Player isabella = new Player("Isabella", dragon);

        dima.start();
        alex.start();
        maria.start();
        john.start();
        sophia.start();
        michael.start();
        emma.start();
        daniel.start();
        olivia.start();
        james.start();
        isabella.start();
    }
}
