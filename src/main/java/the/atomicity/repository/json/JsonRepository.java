package tagcrawler.repository.json;

import tagcrawler.model.GenericMedia;
import tagcrawler.repository.Repository;

import java.math.BigInteger;
import java.util.List;

public class JsonRepository implements Repository {

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
}
