package faang.school.godbless;

    @FunctionalInterface
    public interface ISpellAction<String>{
        String performSpell(String spell);
    }
