package school.BJS2_33687;

public class SpellCaster {

    //Не знаю почему он стал стачным)) видимо я был не в себе)
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.action(spell));
    }
}
