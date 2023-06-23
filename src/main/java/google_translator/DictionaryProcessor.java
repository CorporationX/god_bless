package google_translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String wordTranslation, BiConsumer<String,String> dictionaryAction) {
        dictionaryAction.accept(word,wordTranslation);
    }
}
