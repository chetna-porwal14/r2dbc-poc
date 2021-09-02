package com.example.R2DBCpoc;

import java.util.List;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.PostgresDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.postgresql.codec.EnumCodec;
import io.r2dbc.postgresql.extension.CodecRegistrar;
import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryMetadata;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.Option;

@Configuration
@EnableR2dbcRepositories
public class R2dbcConfig extends AbstractR2dbcConfiguration {

	CodecRegistrar codecRegistrar = EnumCodec.builder().withEnum("pregnancy_status", EPregnancyStatus.class).build();

	PostgresqlConnectionConfiguration configuration = PostgresqlConnectionConfiguration.builder().host("localhost")
			.port(5432).username("postgres").password("postgres")

			.codecRegistrar(codecRegistrar).build();

	// additional configuration .build();

	R2dbcCustomConversions conversions = R2dbcCustomConversions.of(PostgresDialect.INSTANCE,
			new LivestockReadingConverter());

	/*
	 * @Bean ConnectionFactoryInitializer
	 * initializer(@Qualifier("connectionFactory") ConnectionFactory
	 * connectionFactory) { ConnectionFactoryInitializer initializer = new
	 * ConnectionFactoryInitializer();
	 * initializer.setConnectionFactory(connectionFactory); return initializer; }
	 */
	/*
	 * @Bean public ConnectionFactory connectionFactory() {
	 * 
	 * 
	 * return ConnectionFactories.get( ConnectionFactoryOptions.builder()
	 * .option(Option.valueOf("driver"), "postgres" )
	 * .option(Option.valueOf("host"), "localhost") .option(Option.valueOf("user"),
	 * "postgres") .option(Option.valueOf("password"), "postgres")
	 * .option(Option.valueOf("database"), "r2dbc-poc") .build()); }
	 * 
	 */
	
	  @Bean
	  
	  @Override public ConnectionFactory connectionFactory() { return new
	  PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder().host(
	  "localhost") .database("r2dbc-poc").username("postgres").password("postgres")
	  .codecRegistrar(codecRegistrar) .build()
	  
	  ); }
	 
	@Override
	protected List<Object> getCustomConverters() {
		return List.of(new LivestockReadingConverter(), new LivestockPregnancyStatusWritingConverter());
	}

		
}
