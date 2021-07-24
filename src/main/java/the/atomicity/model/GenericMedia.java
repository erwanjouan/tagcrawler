package tagcrawler.model;

import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public interface GenericMedia {

    String getSource();

    Path getPath();

    FileTime getCreationTime();

    FileTime getLastAccessTime();

    FileTime getLastModifiedTime();

    BigInteger getFileSize();

    Object getMetaData();

    MediaType getType();

    BigInteger customHashCode();
}
