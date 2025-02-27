package org.druglibrary.mapper.drug;

import org.druglibrary.entity.Drug;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Service;

@Service
public class RplFieldSetMapper implements DrugFieldSetMapper {

    @Override
    public Drug mapFieldSet(FieldSet fieldSet) {
        return Drug.builder()
                .id(fieldSet.readLong("Identyfikator Produktu Leczniczego"))
                .productName(fieldSet.readString("Nazwa Produktu Leczniczego"))
                .commonName(fieldSet.readString("Nazwa powszechnie stosowana"))
                .administrationRoute(fieldSet.readString("Droga podania - Gatunek - Tkanka - Okres karencji"))
                .pharmaceuticalForm(fieldSet.readString("Postać farmaceutyczna"))
                .marketingAuthorizationHolder(fieldSet.readString("Podmiot odpowiedzialny"))
                .activeSubstance(fieldSet.readString("Substancja czynna"))
                .manufacturerName(fieldSet.readString("Nazwa wytwórcy"))
                .leaflet(fieldSet.readString("Ulotka"))
                .build();
    }

    @Override
    public boolean applies(String name) {
        return name.equals("rpl");
    }
}
