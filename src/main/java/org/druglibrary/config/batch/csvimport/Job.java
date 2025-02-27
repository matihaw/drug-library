package org.druglibrary.config.batch.csvimport;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class Job {

    @Bean
    public org.springframework.batch.core.Job runImportCsv(JobRepository jobRepository, Step downloadCsvStep, Step importFromCsv) {
        return new JobBuilder("importDrugs", jobRepository)
                .start(downloadCsvStep)
                .next(importFromCsv)
                .build();
    }

}
