import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class booking {
	int bookingId;
	int maDV;
	String checkInDate;
	String checkOutDate;

	static listAccount list_user = new listAccount();
	static listRoom list_room = new listRoom();
	static listCustomer list_customer = new listCustomer();
	static listService list_service = new listService();
	static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	static listBill list_bill = new listBill();
	static customer customer = new customer();
	static room_type room = new room_type();
	static service service = new service();
	static bill bill = new bill();

	public static void readFile() throws IOException {
		list_user.docFile();
		list_room.docFile();
		list_customer.docFile();
		list_service.docFile();
	}

	public booking() {
	}

	public booking(int bookingId, int maDV, String checkInDate, String checkOutDate) {
		this.bookingId = bookingId;
		this.maDV = maDV;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getMaDV() {
		return maDV;
	}

	public void setMaDV(int maDV) {
		this.maDV = maDV;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate() throws ParseException {
			LocalDateTime current = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String formatted = current.format(formatter);
			this.checkInDate = formatted;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate() throws ParseException {
		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatted = current.format(formatter);
		this.checkOutDate = formatted;
	}

	public Double tinhTien() {
		Double s = 0.000d;
		String dateIn = "2022-04-25 10:31:48";
		String dateOut = f.format(bill.getPaymentsDate());
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = f.parse(getCheckInDate()); // f.parse(getCheckInDate());
			d2 = f.parse(getCheckInDate());

			System.out.println(dateOut);
			// in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
			System.out.println("=====");
			s = (diffDays * Double.parseDouble(list_room.getPrice(101))) + diffHours * 50;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static void main(String[] args) throws IOException, ParseException {
		readFile();
		booking booking = new booking();
		booking.setCheckInDate();
		booking.setCheckOutDate();
		System.out.println(booking.getCheckInDate());
		System.out.println(booking.getCheckOutDate());
		System.out.println(list_room.getPrice(101));
//		System.out.println(booking.tinhTien());
	}

}
