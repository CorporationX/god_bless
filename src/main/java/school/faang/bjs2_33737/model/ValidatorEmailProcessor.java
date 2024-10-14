package school.faang.bjs2_33737.model;

import school.faang.bjs2_33737.constans.ErrMessagesValidate;

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
        validateNotNull(emails, ErrMessagesValidate.EMAILS_IS_NULL);
        validateNotNull(emailFilter, ErrMessagesValidate.EMAIL_FILTER_IS_NULL);
        validateNotNull(emailBodyTransformer, ErrMessagesValidate.EMAIL_BODY_TRANSFORMER_IS_NULL);
        validateNotNull(emailProcessor, ErrMessagesValidate.EMAIL_PROCESSOR_IS_NULL);
    }
}
