package faang.school.godbless.lambda.task10_GoogleTranslate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translate, BiConsumer<String, String> stringBiConsumer){
        stringBiConsumer.accept(word, translate);
    }
}
