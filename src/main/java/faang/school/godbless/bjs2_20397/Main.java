package faang.school.godbless.bjs2_20397;

import static faang.school.godbless.bjs2_20397.EventType.COMMENT;
import static faang.school.godbless.bjs2_20397.EventType.SUBSCRIBE;

public class Main {
    public static void main(String[] args) {
        var streamEventService = StreamEventService.getInstance();

        var event1 = new StreamEvent(1, SUBSCRIBE, "1");
        var event2 = new StreamEvent(2, SUBSCRIBE, "2");
        var event3 = new StreamEvent(3, SUBSCRIBE, "3");
        var event4 = new StreamEvent(4, COMMENT, "4");

        streamEventService.addStreamEvent(event1);
        streamEventService.addStreamEvent(event2);
        streamEventService.addStreamEvent(event3);
        streamEventService.addStreamEvent(event4);
        streamEventService.print();

        System.out.println("----------------");
        streamEventService.removeStreamEventById(event1.getId());
        streamEventService.print();

        System.out.println("----------------");
        var foundEvent1 = streamEventService.findStreamEventById(event1.getId());
        System.out.println(foundEvent1);
        var foundEvent2 = streamEventService.findStreamEventById(event2.getId());
        System.out.println(foundEvent2);
    }
}
