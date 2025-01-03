package faang.school.godbless.SecondSprint.BJS2_45445;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public static void processWord(String word, String translate, BiConsumer<String, String> biConsumer){
        biConsumer.accept(word, translate);
    }
}
