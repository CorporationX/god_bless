package faang.school.godbless.lambda.task4googletranslate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String wordRus, String wordIng, BiConsumer<String,String> lambda) {
        lambda.accept(wordRus,wordIng);
    }
}
