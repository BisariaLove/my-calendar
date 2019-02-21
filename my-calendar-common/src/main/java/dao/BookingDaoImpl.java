package dao;
/*
 * @author love.bisaria on 19/02/19
 */

import domain.BookingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import configuration.DataSourcesConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookingDaoImpl implements BookingDao{

    private static final Logger log = LoggerFactory.getLogger(BookingDaoImpl.class);

    @Resource(name=DataSourcesConfiguration.MAIN_JDBCTEMPLATE)
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-ddThh:mi:ss.mmmZ");

    private static final String CREATE_BOOKING_SLOT = "INSERT INTO `booking-info`(`slot-id`, `bokee`, `booking-time`)\n" +
            "VALUES(:slotId, :bookeeEmail, :bookingDateTime)";

    @Override
    public BookingInfo makeBooking(BookingInfo bookingInfo){

        Map<String, Object> params = new HashMap();
        params.put("slotId", bookingInfo.getSlotId());
        params.put("bookeeEmail", bookingInfo.getBokee());
        params.put("bookingDateTime", format.format(new Date()));

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValues(params);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        try {
            jdbcTemplate.update(CREATE_BOOKING_SLOT, source, keyHolder);
            int id = keyHolder.getKey().intValue();
            bookingInfo.setId(id);
        } catch (Exception e) {
            log.error("Error Updating Booking.");
        }
        return bookingInfo;
    }

    private static class BookingDaoRowMapper implements RowMapper<BookingInfo>{

        @Override
        public BookingInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

            BookingInfo bookingInfo = new BookingInfo(
                    rs.getInt("id"),
                    rs.getInt("slot-id"),
                    rs.getString("bokee"),
                    rs.getDate("booking-time")
            );

            return bookingInfo;
        }
    }
}
