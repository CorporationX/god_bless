package googleTranlater;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String wordOnRussian, String wordOnEnglish, BiConsumer<String, String> addWordToDictionary) {
        addWordToDictionary.accept(wordOnRussian,wordOnEnglish);
    }
}
