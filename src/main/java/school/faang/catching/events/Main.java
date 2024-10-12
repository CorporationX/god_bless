package school.faang.catching.events;

public class Main {
    public static void main(String[] args) {
        Event event = new Event();
        event.add(101, "a");
        event.add(102, "a");
        event.add(103, "a");
        event.add(104, "a");
        event.add(105, "b");
        event.add(106, "b");
        event.add(107, "b");
        event.add(108, "b");
        event.add(109, "b");
        event.add(110, "b");
        event.add(111, "c");
        event.add(112, "c");
        event.add(113, "c");
        event.add(114, "c");
        event.add(115, "c");
        event.add(116, "c");

        System.out.println(event.searchById(107));
        System.out.println(event.searchByType("b"));

        event.delete(101);
        event.delete(102);
        event.delete(103);

        event.printAll();
    }
}
