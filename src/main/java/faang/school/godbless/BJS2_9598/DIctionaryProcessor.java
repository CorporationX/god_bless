package faang.school.godbless.BJS2_9598;

import java.util.function.BiConsumer;

public class DIctionaryProcessor {

    public void processWord(String word, String translate, BiConsumer<String, String> consumer) {
        consumer.accept(word, translate);
    }
}
