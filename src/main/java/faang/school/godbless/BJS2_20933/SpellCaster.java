package faang.school.godbless.BJS2_20933;

class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.execute(spellName);
        System.out.println(result);
    }
}

