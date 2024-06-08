package faang.school.godbless.BJS2_8977;

public class MainClass {
    public static void main(String[] args) {
        Main main = new Main();

        main.addStreamEvent(1, "тестовое событие", "умное данное события");
        main.addStreamEvent(2, "тестовое событие - 2", "умное данное события - 2");
        main.addStreamEvent(3, "тестовое событие - 3", "умное данное события - 3");
        main.addStreamEvent(4, "тестовое событие - 4", "умное данное события- 4");

        main.printStreamEventList();
        System.out.println("\n");
        main.printEventsList();

        System.out.println("\n");

      //  StreamEvent streamEvent = main.findEventTypeById(2);

      //  System.out.println(streamEvent);

        main.deleteEventById(2);
        main.printStreamEventList();
        System.out.println("\n");
        main.printEventsList();
    }
}
