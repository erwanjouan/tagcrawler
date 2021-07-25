package the.atomicity.tagcrawler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import the.atomicity.tagcrawler.model.GenericMedia;
import the.atomicity.tagcrawler.model.JpgImpl;
import the.atomicity.tagcrawler.repository.postgres.JdbcMediaRepository;
import the.atomicity.tagcrawler.repository.postgres.JdbcPicturesRepository;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

class JdbcRepositoryTest {
    @Test
    void jpegParsing() throws IOException {
        final URL resource = this.getClass().getClassLoader().getResource("img/bird.jpeg");
        final Path path = Paths.get(resource.getPath());
        final BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
        final GenericMedia jpg = JpgImpl.build("source", path, attrs);

        final JdbcMediaRepository underTest = new JdbcPicturesRepository();

        final ObjectMapper objectMapper = underTest.getObjectMapper();

        final String jsonString = objectMapper.writeValueAsString(jpg);
        System.out.println(jsonString);
    }

}