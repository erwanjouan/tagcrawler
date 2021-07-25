package the.atomicity.tagcrawler.service;

import the.atomicity.tagcrawler.model.Mode;
import the.atomicity.tagcrawler.parser.MediaTagParser;
import the.atomicity.tagcrawler.service.persist.PersistService;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Collectors;

public class CrawlerService {

    private MediaTagParser parser;
    private PersistService persistService;

    public CrawlerService(final PersistService persistService) {
        this.parser = new MediaTagParser();
        this.persistService = persistService;
    }

    public void load(final String source, final Path startingDir, final boolean clear, final Mode mode) throws IOException {
        this.persistService.init(source, clear, mode);
        final FileVisitor fileVisitor = new CustomVisitor(source, this);
        Files.walkFileTree(startingDir, fileVisitor);
    }

    void processFolder(final String source, final Path startingDir) throws IOException {
        Files.list(startingDir)
                .map(t -> this.parser.parse(source, t))
                .filter(Objects::nonNull)
                .map(media -> this.persistService.process(media))
                .collect(Collectors.toList());
    }

    public void findDuplicate(final String source) {
        this.persistService.findDuplicate(source);
    }

    public void postLoad() {
        this.persistService.postLoad();
    }
}
