package org.druglibrary.config.batch.csvimport;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DownloadStep {

    @Bean
    public Step downloadCsvStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager, CsvDownloadTasklet tasklet) {
        return new StepBuilder("downloadCsvStep", jobRepository)
                .tasklet(tasklet, platformTransactionManager)
                .build();
    }
}
