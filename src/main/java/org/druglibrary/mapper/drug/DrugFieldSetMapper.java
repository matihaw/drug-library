package org.druglibrary.mapper.drug;

import org.druglibrary.entity.Drug;
import org.springframework.batch.item.file.mapping.FieldSetMapper;

public interface DrugFieldSetMapper extends FieldSetMapper<Drug> {
    boolean applies(String name);
}
