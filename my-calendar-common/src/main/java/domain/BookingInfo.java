package domain;
/*
 * @author love.bisaria on 20/02/19
 */

import java.util.Date;

public class BookingInfo {

    private Integer id;
    private Integer slotId;
    private String bokee;
    private Date bookingDateTime;

    public BookingInfo(Integer id, Integer slotId, String bokee, Date bookingDateTime) {
        this.id = id;
        this.slotId = slotId;
        this.bokee = bokee;
        this.bookingDateTime = bookingDateTime;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public String getBokee() {
        return bokee;
    }

    public Date getBookingDateTime() {
        return bookingDateTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
