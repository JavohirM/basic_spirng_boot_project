package uz.writer.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import uz.writer.config.data.JwtConfigData;
import uz.writer.config.data.R2DBCConfigData;

@Configuration
@EnableConfigurationProperties(value = {R2DBCConfigData.class, JwtConfigData.class})
public class AppConfig {
}
