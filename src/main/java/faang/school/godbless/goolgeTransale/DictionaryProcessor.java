package faang.school.godbless.goolgeTransale;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translate, BiConsumer<String, String> biConsumer){
        biConsumer.accept(word, translate);
    }
}
