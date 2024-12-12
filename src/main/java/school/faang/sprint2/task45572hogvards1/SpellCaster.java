package school.faang.sprint2.task45572hogvards1;

class SpellCaster {
    void cast(String spell, SpellAction action) {
        if (spell == null || action == null) {
            throw new IllegalArgumentException("Спелл и дейстивие должны быть заполнены");
        }
        System.out.println("Достаю ватную палочку." + action.act(spell) + ". Закончилась мана");
    }
}


