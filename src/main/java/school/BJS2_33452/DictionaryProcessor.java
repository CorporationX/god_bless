package school.BJS2_33452;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translateWord, BiConsumer<String,String> biConsumer) {
        biConsumer.accept(word,translateWord);
    }
}