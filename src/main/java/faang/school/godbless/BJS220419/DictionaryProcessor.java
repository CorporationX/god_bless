package faang.school.godbless.BJS220419;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translationWord, BiConsumer<String, String> translation) {
        translation.accept(word, translationWord);
    }
}
