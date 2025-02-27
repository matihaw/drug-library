package org.druglibrary.controller;

import lombok.RequiredArgsConstructor;
import org.druglibrary.service.FileDownloader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ImportController {
    private final JobLauncher jobLauncher;
    private final Job job;
    private final FileDownloader fileDownloader;

    @GetMapping("/import")
    public void doImport() {
        try {
//            this.fileDownloader.downloadFile();

            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("StartAt", System.currentTimeMillis())
                    .toJobParameters();


            this.jobLauncher.run(this.job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException  e) {
            e.printStackTrace();
        }
    }
}
