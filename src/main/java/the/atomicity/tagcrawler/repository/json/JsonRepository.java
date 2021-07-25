package the.atomicity.tagcrawler.repository.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import the.atomicity.tagcrawler.model.GenericMedia;
import the.atomicity.tagcrawler.repository.AbstractRepository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class JsonRepository extends AbstractRepository {

    List<GenericMedia> medias = new ArrayList<>();

    @Override
    public void init(String source, boolean clear) {
    }

    @Override
    public BigInteger check(GenericMedia media) {
        return null;
    }

    @Override
    public BigInteger save(GenericMedia media) {
        this.medias.add(media);
        return media.customHashCode();
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
        ObjectMapper objectMapper = getObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(medias);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
