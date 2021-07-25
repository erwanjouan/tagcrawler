package the.atomicity.tagcrawler.repository;

import the.atomicity.tagcrawler.model.GenericMedia;

import java.math.BigInteger;
import java.util.List;

public interface Repository {

    void init(String source, boolean clear);

    BigInteger check(final GenericMedia media);

    BigInteger save(final GenericMedia media);

    void delete(final String source, final String absolutePath);

    List<String[]> findDuplicate(final String source);

    void postSave();
}