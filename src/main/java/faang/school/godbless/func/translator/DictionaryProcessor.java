package faang.school.godbless.func.translator;

import java.util.function.BiConsumer;

public record DictionaryProcessor() {

    public void processWord(String word, String translation, BiConsumer<String, String> dictionaryAppender) {
        dictionaryAppender.accept(word, translation);
    }
}
