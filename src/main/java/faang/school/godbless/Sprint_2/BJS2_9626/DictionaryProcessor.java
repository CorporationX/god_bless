package faang.school.godbless.Sprint_2.BJS2_9626;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String,String> wordAndTranslate){
        wordAndTranslate.accept(word, translate);

    }
}
