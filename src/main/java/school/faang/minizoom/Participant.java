package school.faang.minizoom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Participant implements Runnable {
    private final Conference conference;
    private final String name;

    @Override
    public void run() {
        System.out.println(name + " is trying to join the conference...");
        conference.join();
        System.out.println(name + " has joined the conference.");
    }
}

