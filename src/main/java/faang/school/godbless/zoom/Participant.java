package faang.school.godbless.zoom;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Participant {
    private final String name;

    public void joinConference(Conference conference) {
        System.out.println("Participant " + this.name + " connected to conference");
        conference.connectToConference();
    }
}
