package org.druglibrary.config.batch.csvimport;

import lombok.RequiredArgsConstructor;
import org.druglibrary.entity.Drug;
import org.druglibrary.repository.DrugRepository;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Writer {
    private final DrugRepository repository;

    @Bean
    public RepositoryItemWriter<Drug> repositoryItemWriter() {
        return new RepositoryItemWriterBuilder<Drug>()
                .repository(this.repository)
                .methodName("save")
                .build();
    }
}
