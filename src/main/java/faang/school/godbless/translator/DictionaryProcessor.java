package faang.school.godbless.translator;

import lombok.Getter;

import java.util.function.BiConsumer;

@Getter
public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> processor) {
        processor.accept(word, translation);
    }
}
