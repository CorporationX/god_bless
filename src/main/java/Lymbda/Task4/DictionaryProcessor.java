package Lymbda.Task4;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String inRussian, String inEnglish, BiConsumer<String, String> biConsumer){
        biConsumer.accept(inRussian,inEnglish);
    }
}
