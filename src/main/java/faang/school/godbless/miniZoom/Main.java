package faang.school.godbless.miniZoom;

public class Main {
    public static void main(String[] args) {
        Conference conference = new Conference("Lecture");

        Participant participant1 = new Participant("Kate");
        Participant participant2 = new Participant("Tom");
        Participant participant3 = new Participant("John");
        Participant participant4 = new Participant("Mary");
        Participant participant5 = new Participant("Jack");

        Thread thread1 = new Thread(() -> participant1.joinConference(conference));
        Thread thread2 = new Thread(() -> participant2.joinConference(conference));
        Thread thread3 = new Thread(() -> participant3.joinConference(conference));
        Thread thread4 = new Thread(() -> participant4.joinConference(conference));
        Thread thread5 = new Thread(() -> participant5.joinConference(conference));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
