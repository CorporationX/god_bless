package faang.school.godbless.sprint3Java8FunctionalInterfacesAndLambdas.task5;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        consumer.accept(word, translation);
    }
}
