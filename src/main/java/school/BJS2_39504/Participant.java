package school.BJS2_39504;

import java.util.Random;

public class Participant {
    private int id;
    private Random random = new Random();
    private Conference conference;

    public Participant(int id, Conference conference) {
        this.conference = conference;
        this.id = id;
    }

    public void joinConference() {
        int timeToJoin = random.nextInt(10000);
        try {
            Thread.sleep(timeToJoin);
            System.out.println("Подключился участник с айди " + id);
            conference.countDawn();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}