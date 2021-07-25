package the.atomicity.tagcrawler.service.persist;

import the.atomicity.tagcrawler.model.GenericMedia;
import the.atomicity.tagcrawler.model.Mode;
import the.atomicity.tagcrawler.repository.Repository;
import the.atomicity.tagcrawler.repository.json.JsonRepository;

import java.math.BigInteger;

public class PersistJsonService implements PersistService {

    private final Repository repository;

    public PersistJsonService() {
        this.repository = new JsonRepository();
    }

    @Override
    public void init(final String source, final boolean clear, final Mode mode) {
        // no op
    }

    @Override
    public BigInteger process(final GenericMedia genericMedia) {
        return this.repository.save(genericMedia);
    }

    @Override
    public void findDuplicate(final String source) {
        // no op
    }

    @Override
    public void postLoad() {
        this.repository.postSave();
    }
}
