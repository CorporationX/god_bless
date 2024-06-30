package faang.school.godbless.multithreading_2.zoom;

public record Participant(String name) {

    public void joinConference(Conference conference) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        conference.join(this);
    }
}
