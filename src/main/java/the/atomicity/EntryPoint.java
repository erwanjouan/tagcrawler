package the.atomicity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tagcrawler.cmd.Runner;

import java.io.IOException;

public class EntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(EntryPoint.class);

    public static void main(final String[] args) throws IOException {
        final String[] hardCodedArgs = {"-p", "main/resources/img", "-s", "test", "-m", "json"};
        new Runner().process(hardCodedArgs);
    }
}
