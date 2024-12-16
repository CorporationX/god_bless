package school.faang.bjs245985;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmailPrcessor {
    private static final Logger logger = LoggerFactory.getLogger(EmailPrcessor.class);

    public void processEmails(List<Email> emailList, Predicate<Email> emailPredicateFilter, Function<Email,
            String> emailFunctionTransformer, Consumer<Email> emailConsumerAction) {

        for (Email email : emailList) {
            logger.debug("Processing Email: {}", email.getSubject());
            if (emailPredicateFilter.test(email)) {
                logger.info("Email passed filter: {}", email.getSubject());
                String transformerBody = emailFunctionTransformer.apply(email);
                email.setBody(transformerBody);
                emailConsumerAction.accept(email);
            } else {
                logger.info("Email didn't pass filter: {} \n", email.getSubject());
            }
        }
    }
}