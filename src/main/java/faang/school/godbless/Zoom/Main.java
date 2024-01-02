package faang.school.godbless.Zoom;

public class Main {
    public static void main(String[] args) {
        var conference = new Conference("Zoom", 3);
        var participant = new Participant("Kergshi");
        var participant1 = new Participant("Higanna");
        var participant2 = new Participant("Sahil");
        new Thread(() -> participant.joinConference(conference)).start();
        new Thread(() -> participant1.joinConference(conference)).start();
        new Thread(() -> participant2.joinConference(conference)).start();
    }
}
