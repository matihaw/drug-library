package org.druglibrary.config.batch.csvimport;

import org.druglibrary.entity.Drug;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ImportStep {
    @Bean
    public Step importFromCsv(
            JobRepository jobRepository,
            PlatformTransactionManager platformTransactionManager,
            FlatFileItemReader<Drug> itemReader,
            RepositoryItemWriter<Drug> repositoryItemWriter
    ) {
        return new StepBuilder("importFromCsv", jobRepository)
                .<Drug, Drug>chunk(100, platformTransactionManager)
                .reader(itemReader)
                .processor(null)
                .writer(repositoryItemWriter)
                .build();
    }
}
