package derschrank.sprint02.task13.bjstwo_45421;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> whatToDo) {
        whatToDo.accept(word, translate);
    }
}
