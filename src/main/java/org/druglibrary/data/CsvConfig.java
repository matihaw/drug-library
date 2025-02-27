package org.druglibrary.data;

import lombok.Data;

@Data
public class CsvConfig {
    private String filePath;
    private String delimiter;
    private int linesToSkip;
    private String[] columnNames;
    private String url;
}
