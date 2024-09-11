package faang.school.godbless.zoom;

public class Participant implements Runnable {
    private final String name;
    private final Conference conference;

    public Participant(String name, Conference conference) {
        this.name = name;
        this.conference = conference;
    }

    @Override
    public void run() {
        try {
            joinConference();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void joinConference() throws InterruptedException {
        Thread.sleep(1000);
        conference.participantArrived(name);
    }
}

