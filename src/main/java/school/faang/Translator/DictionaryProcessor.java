package school.faang.Translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        System.out.println("Adding word \"" + word + "\" and its translation \"" + translation + "\" to Dictionary");
        consumer.accept(word, translation);
    }
}
