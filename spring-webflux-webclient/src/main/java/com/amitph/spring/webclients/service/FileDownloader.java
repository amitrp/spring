package com.amitph.spring.webclients.service;

import com.amitph.spring.webclients.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@RequiredArgsConstructor
public class FileDownloader {
    private final WebClientService webClientService;
    private final ApplicationProperties props;

    @PostConstruct
    public void onApplicationEvent() throws IOException {
        Path output = Paths.get(props.getOutputPath());
        //webClientService.downloadAsByteArray(output);
        //webClientService.downloadUsingMono(output);
        webClientService.downloadUsingFlux(output);
    }
}