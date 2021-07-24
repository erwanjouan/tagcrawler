package tagcrawler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tagcrawler.model.Mode;
import tagcrawler.service.persist.PersistDbService;
import tagcrawler.service.persist.PersistJsonService;
import tagcrawler.service.persist.PersistService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static tagcrawler.model.Mode.isJson;

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
            logger.info(String.format("Processing folder %s", startDir.toAbsolutePath().toString()));
            this.crawlerService.load(this.source, startDir, clear, this.mode);
        }
    }

    public void findDuplicate(final String source) {
        this.crawlerService.findDuplicate(source);
    }

}
