package com.example.R2DBCpoc;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import io.r2dbc.spi.Row;

@ReadingConverter
public class LivestockReadingConverter implements Converter<Row, Livestock>{

	@Override
	public Livestock convert(Row row) {
		return Livestock.builder()
                .id(row.get("id", Integer.class))
                .pregnancyStatus(row.get("pregnancy_status", EPregnancyStatus.class))
                .name(row.get("name", String.class))
                .build();

		
	}

}
