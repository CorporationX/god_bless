package bjs257422;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public enum Alphabet {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F"),
    G("G"),
    H("H"),
    I("I"),
    J("J"),
    K("K"),
    L("L"),
    M("M"),
    N("N"),
    O("O"),
    P("P"),
    Q("Q"),
    R("R"),
    S("S"),
    T("T"),
    U("U"),
    V("V"),
    W("W"),
    X("X"),
    Y("Y"),
    Z("Z");

    private final String upperCaseLetter;

    public static List<Character> convertLettersFromAlphabetToCharacters() {
        List<Character> letters = new ArrayList<>();
        for (Alphabet value : Alphabet.values()) {
            letters.add(value.upperCaseLetter.charAt(0));
        }
        return letters;
    }

    public static List<String> convertLettersFromAlphabetToStrings() {
        List<String> letters = new ArrayList<>();
        for (Alphabet value : Alphabet.values()) {
            letters.add(value.upperCaseLetter);
        }
        return letters;
    }
}
