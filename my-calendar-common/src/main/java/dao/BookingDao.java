package dao;
/*
 * @author love.bisaria on 19/02/19
 */

import configuration.DataSourcesConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class BookingDao {

    @Resource(name=DataSourcesConfiguration.MAIN_JDBCTEMPLATE)
    private NamedParameterJdbcTemplate jdbcTemplate;
}
