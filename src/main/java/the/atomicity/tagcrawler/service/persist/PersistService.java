package the.atomicity.tagcrawler.service.persist;

import the.atomicity.tagcrawler.model.GenericMedia;
import the.atomicity.tagcrawler.model.Mode;

import java.math.BigInteger;

public interface PersistService {

    void init(String source, boolean clear, Mode mode);

    BigInteger process(final GenericMedia genericMedia);

    void findDuplicate(String source);

    void postLoad();
}
