package org.druglibrary.container;

import lombok.RequiredArgsConstructor;
import org.druglibrary.mapper.drug.DrugFieldSetMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrugFieldSetContainer {
    final private List<DrugFieldSetMapper> mappers;

    public DrugFieldSetMapper getMapperFor(String providerName) {
        for (DrugFieldSetMapper mapper : this.mappers) {
            if (mapper.applies(providerName)) {
                return mapper;
            }
        }

        throw new IllegalArgumentException("Mapper for: " + providerName + " has not been registered");
    }

}
