package com.mkide;

import java.nio.file.Path;
import java.util.List;

public class RscFile {
    private final Path file;
    private final List<String> content;

    public RscFile(Path file, List<String> content) {
        this.file = file;
        this.content = content;
    }

    public Path getFile() {
        return file;
    }

    public List<String> getContent() {
        return content;
    }
}
