package school.faang.Lambda.BJS2_33466;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public static void processWord(String word, String translationWord, BiConsumer<String, String> transfer){
        transfer.accept(word, translationWord);
    }
}
