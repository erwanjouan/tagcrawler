package the.atomicity.tagcrawler.parser;

import the.atomicity.tagcrawler.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class MediaTagParser {

    public GenericMedia parse(String source, Path file) {
        try {
            BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
            if (isJPEG(file)) {
                return JpgImpl.build(source, file, attrs);
            } else if (isCR2(file)) {
                return Cr2Impl.build(source, file, attrs);
            } else if (isMov(file)) {
                return MovImpl.build(source, file, attrs);
            } else if (isMp4(file)) {
                return Mp4Impl.build(source, file, attrs);
            }

        } catch (IOException e) {
            return null;
        }
        return null;
    }

    private boolean isMp4(Path file) {
        boolean isMp4 = file.toString().endsWith("MP4");
        isMp4 |= file.toString().endsWith("mp4");
        return isMp4;
    }


    private boolean isJPEG(Path file) {
        boolean isJPEG = file.toString().endsWith("jpg");
        isJPEG |= file.toString().endsWith("jpeg");
        isJPEG |= file.toString().endsWith("JPG");
        isJPEG |= file.toString().endsWith("JPEG");
        return isJPEG;
    }

    private boolean isCR2(Path file) {
        boolean isCR2 = file.toString().endsWith("CR2");
        isCR2 |= file.toString().endsWith("cr2");
        return isCR2;
    }

    private boolean isMov(Path file) {
        boolean isMov = file.toString().endsWith("MOV");
        isMov |= file.toString().endsWith("mov");
        return isMov;
    }

}
