package the.atomicity.tagcrawler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import the.atomicity.tagcrawler.model.Mode;
import the.atomicity.tagcrawler.service.persist.PersistDbService;
import the.atomicity.tagcrawler.service.persist.PersistJsonService;
import the.atomicity.tagcrawler.service.persist.PersistService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static the.atomicity.tagcrawler.model.Mode.isJson;

public class LauncherService {
    private final String source;
    private final Mode mode;
    private final List<Path> startDirs;
    private final PersistService persistService;
    private final CrawlerService crawlerService;


    private static final Logger logger = LoggerFactory.getLogger(LauncherService.class);

    public LauncherService(final String source, final String[] startingDir, final Mode mode) {
        this.source = source;
        this.mode = mode;
        this.persistService = isJson(mode) ? new PersistJsonService() : new PersistDbService();
        this.crawlerService = new CrawlerService(this.persistService);
        this.startDirs = Arrays.asList(startingDir).stream()
                .peek(System.out::println)
                .map(Paths::get)
                .collect(Collectors.toList());
    }

    public void load(final boolean clear) throws IOException {
        for (final Path startDir : this.startDirs) {
            logger.info(String.format("Processing folder %s", startDir.toAbsolutePath()));
            this.crawlerService.load(this.source, startDir, clear, this.mode);
        }
        this.crawlerService.postLoad();
    }

    public void findDuplicate(final String source) {
        this.crawlerService.findDuplicate(source);
    }

}
