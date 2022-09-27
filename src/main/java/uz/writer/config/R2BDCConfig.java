package uz.writer.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.Option;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import uz.writer.config.data.R2DBCConfigData;

@Configuration
@EnableR2dbcRepositories
public class R2BDCConfig extends AbstractR2dbcConfiguration {


    private final R2DBCConfigData data;

    public R2BDCConfig(R2DBCConfigData data) {
        this.data = data;
    }

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {

        ConnectionFactoryOptions options = ConnectionFactoryOptions.builder()
                .option(ConnectionFactoryOptions.DRIVER, data.getDriver())
                .option(ConnectionFactoryOptions.HOST, data.getHost())
                .option(ConnectionFactoryOptions.PORT, data.getPort())
                .option(ConnectionFactoryOptions.DATABASE, data.getDatabase())
                .option(ConnectionFactoryOptions.USER, data.getUsername())
                .option(ConnectionFactoryOptions.PASSWORD, data.getPassword())
                .option(Option.valueOf("locale"), data.getLocale())
                .build();

        return ConnectionFactories.get(options);
    }

}
