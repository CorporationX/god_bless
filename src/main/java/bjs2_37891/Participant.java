package bjs2_37891;

public class Participant {

    public void joinConference(Conference conference) throws InterruptedException {
        conference.addParticipant();
        System.out.println("Participant joined the conference!");
    }
}
