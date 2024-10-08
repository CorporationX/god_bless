package school.faang.BJS233254;

public class Main {
    public static StreamEventService service = new StreamEventServiceImpl();

    public static void main(String[] args) {
        service.addEvent(EventType.BABYSHOWER, "9 месяц");
        service.addEvent(EventType.BDPARTY, "18 летие");
        service.addEvent(EventType.GENDERPARTY, "Девочка");
        service.addEvent(EventType.FUNERAL, "Бабушка");
        service.addEvent(EventType.BDPARTY, "50 летие");
        service.addEvent(EventType.BABYSHOWER, "9 месяц");
        service.addEvent(EventType.GENDERPARTY, "Мальчик");

        System.out.println(service.findEventById(2));
        System.out.println(service.findListByEventType(EventType.GENDERPARTY));
        service.deleteEvent(7);
        service.deleteEvent(3);
        service.addEvent(EventType.BDPARTY, "33 летие");
        service.printAll();

    }
}
