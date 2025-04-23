package school.faang.spotify;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
public class Music {

    private int currentIndex;
    private final List<String> music = List.of(
            "Song 1",
            "Song 2",
            "Song 3",
            "Song 4",
            "Song 5",
            "Song 6",
            "Song 7",
            "Song 8",
            "Song 9",
            "Song 10",
            "Song 11",
            "Song 12",
            "Song 13",
            "Song 14",
            "Song 15"
    );

    public void incrementIndex() {
        currentIndex++;
    }

    public void decrementIndex() {
        currentIndex--;
    }
}