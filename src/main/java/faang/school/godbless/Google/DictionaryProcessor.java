package faang.school.godbless.Google;

public class DictionaryProcessor {
    void processWord(String originWord, String translatedWord, BiConsumer biConsumer){
        biConsumer.translater(originWord,translatedWord);
    }
}
