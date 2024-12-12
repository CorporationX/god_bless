package school.faang.sprint_2.task_45444;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word,
                            String translation,
                            BiConsumer<String, String> saveAlgorithm) {
        saveAlgorithm.accept(word, translation);
    }
}
