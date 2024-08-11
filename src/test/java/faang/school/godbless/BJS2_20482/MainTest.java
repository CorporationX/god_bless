package faang.school.godbless.BJS2_20482;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
    Map<String, List<StreamEvent>> eventsListMap = new HashMap<>();

    @BeforeEach
    void init() {
        streamEventMap = new HashMap<>();
        eventsListMap = new HashMap<>();
        var givenEvents = List.of(
                new StreamEvent(1, "login", "User 1 logged in"),
                new StreamEvent(2, "purchase", "User 2 purchased item"),
                new StreamEvent(3, "login", "User 3 logged in"),
                new StreamEvent(4, "logout", "User 1 logged out"),
                new StreamEvent(5, "purchase", "User 3 purchased item"),
                new StreamEvent(6, "password_change", "User 2 changed password"),
                new StreamEvent(7, "login", "User 4 logged in"),
                new StreamEvent(8, "logout", "User 2 logged out"),
                new StreamEvent(9, "profile_update", "User 3 updated profile"),
                new StreamEvent(10, "purchase", "User 4 purchased item")
        );

        for (var givenEvent : givenEvents) {
            streamEventMap.put(givenEvent.getId(), givenEvent);
            eventsListMap.computeIfAbsent(givenEvent.getEventType(), k -> new ArrayList<>()).add(givenEvent);
        }
    }

    @Test
    void addStreamEventAndRenewMaps() {
        var event = new StreamEvent(11, "delete", "User 1 deleted account");

        Main.addStreamEventAndRenewMaps(event, streamEventMap, eventsListMap);

        assertThat(streamEventMap).containsKey(11).containsKey(2).containsKey(3)
                .hasSize(11);
        assertThat(eventsListMap).containsKey("login").containsKey("purchase")
                .containsKey("delete").hasSize(6);
        assertThat(eventsListMap.get("login")).hasSize(3);
    }


    @Test
    void getStreamEventById() {
        var givenEvent = new StreamEvent(6, "password_change", "User 2 changed password");
        streamEventMap.put(6, givenEvent);
        var result = Main.getStreamEventById(6, streamEventMap);

        assertThat(result).isEqualTo(givenEvent);
    }

    @Test
    void getStreamEventsByEventType() {
        var givenEvent1 = new StreamEvent(1, "login", "User 1 logged in");
        var givenEvent2 = new StreamEvent(3, "login", "User 3 logged in");
        var givenEvent3 = new StreamEvent(7, "login", "User 4 logged in");
        var result = Main.getStreamEventsByEventType("login", eventsListMap);

        assertThat(result).containsExactly(givenEvent1, givenEvent2, givenEvent3);
        assertThat(result).hasSize(3);
    }

    @Test
    void deleteStreamEventById() {
        Main.deleteStreamEventById(3, streamEventMap, eventsListMap);
        assertThat(streamEventMap).doesNotContainKey(3).hasSize(9);
        assertThat(eventsListMap).doesNotContainKey("login").containsKey("purchase").containsKey("logout")
                .hasSize(4);
    }

    @Test
    void printAllInfo() {
        System.setOut(new PrintStream(outputStreamCaptor));
        String expectedOutput = """
                ID: 1 Event: login
                ID: 2 Event: purchase
                ID: 3 Event: login
                ID: 4 Event: logout
                ID: 5 Event: purchase
                ID: 6 Event: password_change
                ID: 7 Event: login
                ID: 8 Event: logout
                ID: 9 Event: profile_update
                ID: 10 Event: purchase
                """;
        Main.printAllInfo(streamEventMap);
        assertThat(normalize(outputStreamCaptor.toString())).isEqualTo(normalize(expectedOutput));
        System.setOut(System.out);
    }

    private String normalize(String input) {
        return input.strip().replaceAll("\\s+", " ");
    }

}