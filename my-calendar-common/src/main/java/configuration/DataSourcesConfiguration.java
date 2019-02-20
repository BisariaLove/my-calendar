package configuration;
/*
 * @author love.bisaria on 19/02/19
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourcesConfiguration implements DatabaseConfig{

    public static final String MAIN_DATASOURCE = "mainDbDatasource";
    public static final String MAIN_JDBCTEMPLATE = "mainDbJdbcTemplate";

    @Bean(name=MAIN_DATASOURCE)
    @ConfigurationProperties(prefix="spring.main.datasource")
    public DataSource mainDbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name=MAIN_JDBCTEMPLATE)
    public NamedParameterJdbcTemplate mainDbJdbcTemplate() {
        return new NamedParameterJdbcTemplate(mainDbDataSource());
    }

}
