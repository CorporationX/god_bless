package school.faang.bjs250994;

public class Main {
    public static void main(String[] args) {

        int requiredParticipants = 100;
        Conference conference = new Conference(requiredParticipants);

        for (int i = 0; i < requiredParticipants; i++) {
            Participant participant = new Participant(conference);
            Thread thread = new Thread(participant, "Participant - " + (i + 1));
            thread.start();
        }
    }
}