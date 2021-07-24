package tagcrawler.model;

import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public interface Picture {

    String getISOSpeedRatings();

    String getModel();

    String getImageWidth();

    String getImageHeight();

    String getExposureTime();

    String getFNumber();

    String getFocalLength();

    Path getPath();

    long getFileSize();

    FileTime getCreationTime();

    FileTime getLastAccessTime();

    FileTime getLastModifiedTime();

}

