package Sprint_4_1_Task8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class PotionAlchemy {
    List<Potion> potionList;
    @SneakyThrows
    public double gatherIngredients(Potion potion){
        TimeUnit.SECONDS.sleep(3);
        return (Math.random()*10)+1;
    }

    public static void main(String[] args) {
        CompletableFuture<PotionAlchemy> future = new CompletableFuture<>();
    }
}
