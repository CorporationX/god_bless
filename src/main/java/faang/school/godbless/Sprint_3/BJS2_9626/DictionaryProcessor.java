package faang.school.godbless.Sprint_3.BJS2_9626;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String,String> wordAndTranslate){
        wordAndTranslate.accept(word, translate);

    }
}
