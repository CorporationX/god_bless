package school.faang.catchingEvents;

public class Main {
  public static void main(String[] args) {

    StreamEventService streamEventRepository = new StreamEventService();

    streamEventRepository.addStreamEvent(new StreamEvent(0, "2", "12312"));
    streamEventRepository.addStreamEvent(new StreamEvent(1, "2", "12321313"));
    streamEventRepository.addStreamEvent(new StreamEvent(2, "23", "12321313"));
    streamEventRepository.addStreamEvent(new StreamEvent(3, "23", "1111"));

    System.out.println(streamEventRepository.getEvents());
    System.out.println(streamEventRepository.getGroupEvents());

    System.out.println("=============");

    System.out.println(streamEventRepository.findStreamEventById(3));
    System.out.println(streamEventRepository.findArraysStreamEventByEventType("23"));

    streamEventRepository.deleteStreamEvent(5);
    streamEventRepository.deleteStreamEvent(0);

    System.out.println("=============");

    System.out.println(streamEventRepository.getEvents());
    System.out.println(streamEventRepository.getGroupEvents());



  }
}
