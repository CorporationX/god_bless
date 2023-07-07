package faang.school.godbless.google_translate;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Data
public class DictionaryProcessor {

    private final Map<String, String> dictionary = new HashMap<>();

    public void processWord(String word, String translation, BiConsumer<String, String> processor) {
        processor.accept(word, translation);
    }
}
