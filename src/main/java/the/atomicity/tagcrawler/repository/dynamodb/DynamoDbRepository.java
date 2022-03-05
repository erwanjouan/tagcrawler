package the.atomicity.tagcrawler.repository.dynamodb;

import the.atomicity.tagcrawler.model.GenericMedia;
import the.atomicity.tagcrawler.repository.Repository;

import java.math.BigInteger;
import java.util.List;

public class DynamoDbRepository implements Repository {

    @Override
    public void init(String source, boolean clear) {

    }

    @Override
    public BigInteger check(GenericMedia media) {
        return null;
    }

    @Override
    public BigInteger save(GenericMedia media) {
        return null;
    }

    @Override
    public void delete(String source, String absolutePath) {

    }

    @Override
    public List<String[]> findDuplicate(String source) {
        return null;
    }

    @Override
    public void postSave() {

    }
}
