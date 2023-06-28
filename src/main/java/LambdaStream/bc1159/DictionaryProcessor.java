package LambdaStream.bc1159;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String wordTranslate, BiConsumer<String, String> biConsumer){
        biConsumer.accept(word, wordTranslate);
    }
}
