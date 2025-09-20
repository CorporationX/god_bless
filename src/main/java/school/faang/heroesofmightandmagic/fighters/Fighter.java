package school.faang.heroesofmightandmagic.fighters;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Fighter {
    protected int health;
    protected int power;
}