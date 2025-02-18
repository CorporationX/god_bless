package school.faang.task57954.notification;

import lombok.Getter;

import java.util.List;

@Getter
public enum WordFilter {
    BAD_WORDS(List.of("багет", "котики"));

    private final List<String> word;

    WordFilter(List<String> word) {
        this.word = word;
    }
}
