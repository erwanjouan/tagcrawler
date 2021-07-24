package tagcrawler.service.persist;

import tagcrawler.model.GenericMedia;
import tagcrawler.model.Mode;

import java.math.BigInteger;

public interface PersistService {
    void init(String source, boolean clear, Mode mode);

    BigInteger process(final GenericMedia genericMedia);

    void findDuplicate(String source);
}
