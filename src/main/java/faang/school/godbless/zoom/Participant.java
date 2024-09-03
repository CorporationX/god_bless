package faang.school.godbless.zoom;

public record Participant(String name) {
    public void joinConference(Conference conference) {
        try {
            conference.getCountDownLatch().await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            conference.startStreaming();
        }
    }
}
