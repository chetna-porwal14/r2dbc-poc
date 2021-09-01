package com.example.R2DBCpoc;

import org.springframework.boot.logging.logback.ColorConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.PostgresDialect;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.codec.EnumCodec;
import io.r2dbc.postgresql.extension.CodecRegistrar;

@Configuration
public class EnumConfig {
	
	CodecRegistrar codecRegistrar = EnumCodec.builder().withEnum("pregnancy_status", EPregnancyStatus.class).build();

	PostgresqlConnectionConfiguration configuration = PostgresqlConnectionConfiguration.builder()
			.host("localhost")
			.port(5432)
			.username("postgres")
			.password("postgres")
	 
	    .codecRegistrar(codecRegistrar)
	 
	    // additional configuration
	    .build();
	
	R2dbcCustomConversions conversions = R2dbcCustomConversions.of(PostgresDialect.INSTANCE, new MyEnumTypeConverter());

}
