package tagcrawler.service.persist;

import tagcrawler.model.GenericMedia;
import tagcrawler.model.Mode;

import java.math.BigInteger;

public class PersistJsonService implements PersistService {

    @Override
    public void init(final String source, final boolean clear, final Mode mode) {
        // no op
    }

    @Override
    public BigInteger process(final GenericMedia genericMedia) {
        return null;
    }

    @Override
    public void findDuplicate(final String source) {
        // no op
    }
}
