package faang.school.godbless.Zoom;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Participant {
    private String name;

    public void joinConference(Conference conference) {
        System.out.println(name + " joining conference " + conference.getName());
        conference.startStreaming();
    }
}