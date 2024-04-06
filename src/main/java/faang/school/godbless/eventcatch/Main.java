package faang.school.godbless.eventcatch;

public class Main {
    public static void main(String[] args) {
        StreamEventProcessor stream = new StreamEventProcessor();
        StreamEvent streamEvent1 = new StreamEvent(1, "call", "random call");
        StreamEvent streamEvent2 = new StreamEvent(2, "call", "another random call");
        StreamEvent streamEvent3 = new StreamEvent(3, "income call", "income call from someone");
        StreamEvent streamEvent4 = new StreamEvent(4, "income call", "undefined income call");
        StreamEvent streamEvent5 = new StreamEvent(5, "research", "inner research");

        stream.addNewEvent(streamEvent1);
        stream.addNewEvent(streamEvent2);
        stream.addNewEvent(streamEvent3);
        stream.addNewEvent(streamEvent4);
        stream.addNewEvent(streamEvent5);

        stream.showAllEvents();

        System.out.println(stream.findById(2));

        System.out.println(stream.findByType("call"));

        stream.deleteById(5);

        stream.showAllEvents();
    }
}
