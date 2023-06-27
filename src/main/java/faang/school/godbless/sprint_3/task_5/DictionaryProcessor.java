package faang.school.godbless.sprint_3.task_5;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translateWord, BiConsumer<String, String> dictionaryProcessing) {
        dictionaryProcessing.accept(word, translateWord);
    }
}
