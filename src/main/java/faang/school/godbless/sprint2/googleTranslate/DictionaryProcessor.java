package faang.school.godbless.sprint2.googleTranslate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord (String word, String translate, BiConsumer<String,String> biConsumer){
        biConsumer.accept(word,translate);
    }
}
