package faang.school.godbless.sprint4.zoom;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        int requiredParticipants = 5;
        Conference conference = new Conference(requiredParticipants);

        for (int i = 0; i < requiredParticipants; i++) {
            Participant participant = new Participant(conference);
            new Thread(participant).start();
        }
    }
}
