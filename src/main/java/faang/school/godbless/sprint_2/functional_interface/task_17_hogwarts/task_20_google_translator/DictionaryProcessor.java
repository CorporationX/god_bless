package faang.school.godbless.sprint_2.functional_interface.task_17_hogwarts.task_20_google_translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translate, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translate);
    }
}
