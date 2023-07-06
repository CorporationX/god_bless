package faang.school.godbless.sprint3_lambda.google;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> bc) {
        bc.accept(word, translation);
    }
}
