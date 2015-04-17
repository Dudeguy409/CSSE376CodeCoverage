package ExpediaTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Expedia.Hotel;
import Expedia.IDatabase;
import Expedia.User;

public class HotelTest {

	IDatabase db;

	@Before
	public void TestInitialize() {
		db = new IDatabase() {

			@Override
			public String getRoomOccupant(int roomNumber) {
				return "40";
			}

			@Override
			public String getCarLocation(int carNumber) {
				return "Canada";
			}
		};

		db.Rooms = new ArrayList<>();
	}

	@Test
	public void TestNormalHotel() {
		Hotel h = new Hotel(4);
		h.Database = db;
		assertEquals(h.AvailableRooms(), 0);
		assertEquals(h.getRoomOccupant(4), "40");
		assertEquals(h.getMiles(), 0);
	}

	@Test(expected = Exception.class)
	public void TestInvalidHotel() {
		Hotel h = new Hotel(0);
	}
}
