package configuration;
/*
 * @author love.bisaria on 19/02/19
 */

import javax.sql.DataSource;

public interface DatabaseConfig {
    public DataSource mainDbDataSource();
}
