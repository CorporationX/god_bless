package faang.school.godbless.BJS2_20589;

import lombok.NoArgsConstructor;

import java.util.function.BiConsumer;

@NoArgsConstructor
public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translation);
    }
}
