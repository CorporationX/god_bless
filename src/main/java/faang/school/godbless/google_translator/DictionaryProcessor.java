package faang.school.godbless.google_translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String s1, String s2, BiConsumer<String, String> addition){
        addition.accept(s1, s2);
    }}
