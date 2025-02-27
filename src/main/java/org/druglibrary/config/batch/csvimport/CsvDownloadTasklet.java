package org.druglibrary.config.batch.csvimport;

import lombok.RequiredArgsConstructor;
import org.druglibrary.data.CsvConfig;
import org.druglibrary.data.CsvConfigLoader;
import org.druglibrary.service.FileDownloader;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CsvDownloadTasklet implements Tasklet {
    private final FileDownloader fileDownloader;
    private final CsvConfig csvConfig;

    @Autowired
    public CsvDownloadTasklet(CsvConfigLoader configLoader, FileDownloader fileDownloader) {
        this.csvConfig = configLoader.getCurrentProviderConfig();
        this.fileDownloader = fileDownloader;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        this.fileDownloader.downloadFile(this.csvConfig.getUrl(), this.csvConfig.getFilePath());

        return RepeatStatus.FINISHED;
    }
}
