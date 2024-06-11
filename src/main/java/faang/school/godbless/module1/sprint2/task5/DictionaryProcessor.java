package faang.school.godbless.module1.sprint2.task5;

import lombok.ToString;

import java.util.function.BiConsumer;

@ToString
public class DictionaryProcessor {


    public void processWord(String word, String wordTranslate, BiConsumer<String, String> writer) {
        writer.accept(word, wordTranslate);
    }
}
