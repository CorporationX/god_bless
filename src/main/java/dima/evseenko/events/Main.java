package dima.evseenko.events;

public class Main {
    public static void main(String[] args) {
        StreamController controller = new StreamController();
        controller.addEvent(new StreamEvent(1L, EventType.STREAM_VIDEO, "video1..."));
        controller.addEvent(new StreamEvent(2L, EventType.STREAM_VIDEO, "video2..."));
        controller.addEvent(new StreamEvent(3L, EventType.STREAM_AUDIO, "audio1..."));
        controller.addEvent(new StreamEvent(4L, EventType.STREAM_AUDIO, "audio2..."));

        controller.printEvents();

        System.out.println(controller.getEvent(1L));
        System.out.println(controller.getEvents(EventType.STREAM_VIDEO));
        System.out.println(controller.getEvents(EventType.STREAM_AUDIO));
    }
}
