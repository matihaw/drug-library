package org.druglibrary.config.batch.csvimport;

import org.druglibrary.container.DrugFieldSetContainer;
import org.druglibrary.data.CsvConfig;
import org.druglibrary.data.CsvConfigLoader;
import org.druglibrary.entity.Drug;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.separator.DefaultRecordSeparatorPolicy;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class Reader {

    @Value("${csv.configs.drugs-import.source}")
    private String importSource;

    private final CsvConfig csvConfig;
    private final DrugFieldSetContainer fieldSetMappers;

    @Autowired
    public Reader(CsvConfigLoader configLoader, DrugFieldSetContainer fieldSetMappers) {
        this.csvConfig = configLoader.getCurrentProviderConfig();
        this.fieldSetMappers = fieldSetMappers;
    }

    @Bean
    public FlatFileItemReader<Drug> itemReader() {
        return new FlatFileItemReaderBuilder<Drug>()
                .resource(new FileSystemResource(this.csvConfig.getFilePath()))
                .name("csvReader")
                .linesToSkip(this.csvConfig.getLinesToSkip())
                .lineMapper(this.lineMapper())
                .recordSeparatorPolicy(new DefaultRecordSeparatorPolicy())
                .build();
    }

    private LineMapper<Drug> lineMapper() {
        DefaultLineMapper<Drug> lineMapper = new DefaultLineMapper<>();

        lineMapper.setLineTokenizer(this.getTokenizer());
        lineMapper.setFieldSetMapper(this.getFiledSetMapper());

        return lineMapper;
    }

    private DelimitedLineTokenizer getTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(this.csvConfig.getDelimiter());
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(this.csvConfig.getColumnNames());

        return lineTokenizer;
    }

    private FieldSetMapper<Drug> getFiledSetMapper() {
        return this.fieldSetMappers.getMapperFor(this.importSource);
    }

}
