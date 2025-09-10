package school.faang.bjs2_87322;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String rusWord, String engWord, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(rusWord, engWord);
    }
}
