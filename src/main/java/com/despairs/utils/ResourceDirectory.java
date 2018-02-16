package com.despairs.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author EKovtunenko
 */
public class ResourceDirectory {

    private final String dir;
    private final Path path;

    public ResourceDirectory(String dir) {
        this.dir = dir;
        try {
            URI resourceUri = getClass().getClassLoader().getResource(dir).toURI();
            this.path = Paths.get(resourceUri);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<String> ls() throws IOException {
        return Files.list(path)
                .map(Path::getFileName)
                .map(Path::toString)
                .map(s -> dir + "/" + s)
                .collect(Collectors.toList());
    }

}
