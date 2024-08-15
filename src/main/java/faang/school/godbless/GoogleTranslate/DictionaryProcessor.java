package faang.school.godbless.GoogleTranslate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String originalWord, String translatedWord, BiConsumer<String,String> fncTranslate){
        fncTranslate.accept(originalWord,translatedWord);
    }
}
