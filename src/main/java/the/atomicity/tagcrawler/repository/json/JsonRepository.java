package the.atomicity.tagcrawler.repository.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import the.atomicity.tagcrawler.model.GenericMedia;
import the.atomicity.tagcrawler.repository.AbstractRepository;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class JsonRepository extends AbstractRepository {

    List<GenericMedia> medias = new ArrayList<>();

    @Override
    public void init(final String source, final boolean clear) {
    }

    @Override
    public BigInteger check(final GenericMedia media) {
        return null;
    }

    @Override
    public BigInteger save(final GenericMedia media) {
        this.medias.add(media);
        return media.customHashCode();
    }

    @Override
    public void delete(final String source, final String absolutePath) {

    }

    @Override
    public List<String[]> findDuplicate(final String source) {
        return null;
    }

    @Override
    public void postSave() {
        final ObjectMapper objectMapper = this.getObjectMapper();
        try {
            final String json = objectMapper.writeValueAsString(this.medias);
            final File file = new File("media.json");
            objectMapper.writeValue(file, this.medias);
            //System.out.println(json);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
