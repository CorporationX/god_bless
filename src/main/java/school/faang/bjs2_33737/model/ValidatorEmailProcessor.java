package school.faang.bjs2_33737.model;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ValidatorEmailProcessor {
    private void validateNotNull(Object object,String errMessage){
        if(object == null){
            throw new IllegalArgumentException(errMessage);
        }
    }

    public void validateProcessEmails(List<Email> emails, Predicate<Email> emailFilter, Function<Email, String> emailBodyTransformer,
                                      Consumer<Email> emailProcessor){
        validateNotNull(emails, "the emails list cannot be null");
        validateNotNull(emailFilter, "the email filter cannot be null");
        validateNotNull(emailBodyTransformer, "the email body transformer cannot be null");
        validateNotNull(emailProcessor, "the email processor cannot be null");
    }
}
