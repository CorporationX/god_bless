package faang.school.godbless;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translatedWord, BiConsumer<String, String> dictionary){
        dictionary.accept(word, translatedWord);
    }
}
