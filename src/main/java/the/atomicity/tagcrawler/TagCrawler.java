package the.atomicity.tagcrawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import the.atomicity.tagcrawler.cmd.Runner;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class TagCrawler {

    private static final Logger logger = LoggerFactory.getLogger(TagCrawler.class);

    private static String getBirdFolder() throws URISyntaxException {
        URI uri = TagCrawler.class.getClassLoader().getResource("img/bird.jpeg").toURI();
        return new File(uri).getParentFile().toString();
    }

    private static String getExampleFolder() throws URISyntaxException {
        return new File("/home/lena/dev/testPictures").toString();
    }

    public static void main(final String[] args) throws URISyntaxException {
        //String imgFolder = getBirdFolder();
        String imgFolder = getExampleFolder();
        final String[] hardCodedArgs = {"-p", imgFolder, "-s", "test", "-m", "json"};
        new Runner().process(hardCodedArgs);
    }
}
