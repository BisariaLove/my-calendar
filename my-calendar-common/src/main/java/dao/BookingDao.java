package dao;
/*
 * @author love.bisaria on 19/02/19
 */


import domain.BookingInfo;

public interface BookingDao {

    public BookingInfo makeBooking(BookingInfo bookingInfo);
}
