package school.faang.task_45432;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Getter
public class DictionaryProcessor {
    private final Map<String, String> dictionary = new HashMap<>();
    private static final String EMPTY_FIELD_ERROR = "%s не может быть пустым";

    public void addWord(String originalWord, String translatedWord) {
        if (originalWord == null || originalWord.isEmpty()) {
            throw new RuntimeException(String.format(EMPTY_FIELD_ERROR, "originalWord"));
        }
        if (translatedWord == null || translatedWord.isEmpty()) {
            throw new RuntimeException(String.format(EMPTY_FIELD_ERROR, "translatedWord"));
        }
        processWord(originalWord, translatedWord, dictionary::put);
    }

    private void processWord(String originalWord,
                             String translatedWord,
                             BiConsumer<String, String> biConsumer) {
        biConsumer.accept(originalWord, translatedWord);
    }
}
