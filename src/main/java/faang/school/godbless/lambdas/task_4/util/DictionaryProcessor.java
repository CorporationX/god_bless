package faang.school.godbless.lambdas.task_4.util;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> wordAndTranslation) {
        wordAndTranslation.accept(word, translation);
        System.out.println("Пара " + word + " - " + translation + " добавлена в словарь");
    }
}