package school.faang.spring2.task_45433;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class User {
    private String name;
    @Getter
    private Map<String, String> dictionary;

    public User(String name) {
        this.name = name;
        this.dictionary = new HashMap<>();
    }

    public BiConsumer<String, String> addWord() {
        return (w, t) -> dictionary.put(w, t);
    }
}
