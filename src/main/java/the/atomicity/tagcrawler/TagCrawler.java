package the.atomicity.tagcrawler;

import the.atomicity.tagcrawler.cmd.RunnerFromProperties;

public class TagCrawler {

    public static void main(final String[] args) {
        new RunnerFromProperties().launch();
    }
}
