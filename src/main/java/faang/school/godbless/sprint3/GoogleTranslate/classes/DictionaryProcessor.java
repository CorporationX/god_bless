package faang.school.godbless.sprint3.GoogleTranslate.classes;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public static final String NULLABLE_VALUE_EXCEPTION = "Nullable value";
    public static final String EMPTY_VALUE_EXCEPTION = "Empty value";
    public void processWord(String word, String translate, BiConsumer<String, String> consumer) {
        if (word == null || translate == null){
            throw new IllegalArgumentException(NULLABLE_VALUE_EXCEPTION);
        }
        if (word.isEmpty() || translate.isEmpty()){
            throw  new IllegalArgumentException(EMPTY_VALUE_EXCEPTION);
        }
        consumer.accept(word, translate);
    }
}
