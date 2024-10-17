package module_2.module_2_1_Lambda.google_translate_33542;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String,String> biConsumer) {
        biConsumer.accept(word, translation);
    }
}
