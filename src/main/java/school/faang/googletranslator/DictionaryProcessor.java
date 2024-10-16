package school.faang.googletranslator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.function.BiConsumer;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryProcessor {

    private Map<String, String> dictionary;

    public void processWord(String word, String translation, BiConsumer<String, String> action) {
        action.accept(word, translation);
    }
}
