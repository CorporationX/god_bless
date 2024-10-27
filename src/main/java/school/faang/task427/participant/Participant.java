package school.faang.task427.participant;

import lombok.AllArgsConstructor;
import school.faang.task427.conference.Conference;

@AllArgsConstructor
public class Participant implements Runnable {
    private Conference conference;

    public void joinConference() {
        conference.join();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " пытается присоеденится к конференции");
        joinConference();
        System.out.println(Thread.currentThread().getName() + " присоеденился к конференции");
    }
}
