package lymbda.task4;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String inRussian, String inEnglish, BiConsumer<String, String> dictionaryConsumer) {
        dictionaryConsumer.accept(inRussian, inEnglish);
    }
}
