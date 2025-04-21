package school.faang.functional_interfaces_lambda_2_1.bjs2_70329;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        var result = spellAction.magic(spellName);
        log.info("{}", result);
    }
}
