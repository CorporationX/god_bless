package faang.school.godbless.google;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> saveWord){
        saveWord.accept( word, translation );
    }
}
