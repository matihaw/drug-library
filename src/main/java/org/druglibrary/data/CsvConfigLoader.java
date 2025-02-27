package org.druglibrary.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "csv.configs.drugs-import")
@Setter
public class CsvConfigLoader {
    private Map<String, CsvConfig> providers;
    private String source;

    public CsvConfig getCurrentProviderConfig() {
        return this.providers.get(this.source);
    }
}
