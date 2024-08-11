package com.functional.hogwarts;

public class SpellCaster {

    void cast(String castName, SpellAction spellAction) {
        System.out.println(spellAction.cast(castName));
    }
}
