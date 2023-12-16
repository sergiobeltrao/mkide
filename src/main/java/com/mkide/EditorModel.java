package com.mkide;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class EditorModel {

    public void save(RscFile rscFile) {
        try {
            Files.write(rscFile.getFile(), rscFile.getContent(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public IOResult<RscFile> load(Path file) {
        try {
            List<String> lines = Files.readAllLines(file);
            return new IOResult<>(true, new RscFile(file, lines));
        } catch (IOException e) {
            e.printStackTrace();
            return new IOResult<>(false, null);
        }
    }

    public void close() {
        System.exit(0);
    }
}
