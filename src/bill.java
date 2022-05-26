import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class bill {
	int id; // ma hoa don
	int maNV;
	int maKH; // ma khach
	int maDV; // ma dich vu
	int maPhong;
	String checkIn;
	String checkOut;
	String price;
	Date paymentsDate;

	Scanner sc = new Scanner(System.in);
	DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	account account = new account();
	customer customer = new customer();
	service service = new service();
	booking booking = new booking();

	public bill() {
	}

	public bill(int id, int maNV, int maKH, int maDV, int maPhong, String checkIn, String checkOut, String price,
			Date paymentsDate) {
		super();
		this.id = id;
		this.maNV = maNV;
		this.maKH = maKH;
		this.maDV = maDV;
		this.maPhong = maPhong;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.price = price;
		this.paymentsDate = paymentsDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public int getMaDV() {
		return maDV;
	}

	public void setMaDV(int maDV) {
		this.maDV = maDV;
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getPaymentsDate() {
		return paymentsDate;
	}

	public void setPaymentsDate() throws ParseException {
		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatted = current.format(formatter);
		this.paymentsDate = f.parse(formatted);
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public void nhap() throws ParseException {
		setMaNV(Integer.parseInt(account.getMa_tk()));
		setMaKH(customer.getMaKH());
		setMaPhong(customer.getMaPhong());
		setMaDV(service.getMaDV());
		setCheckIn(booking.getCheckInDate());
		setCheckOut(booking.getCheckOutDate());
		setPrice(String.valueOf(booking.tinhTien()));
		setPaymentsDate();
	}

	public void writeFile(BufferedWriter out) throws IOException {
		try {
			// khi viet file viet them dau | vao giua
			out.write(this.getId() + "|");
			out.write(this.getMaNV() + "|");
			out.write(this.getMaKH() + "|");
			out.write(this.getMaPhong() + "|");
			out.write(this.getMaDV() + "|");
			out.write(this.getCheckIn() + "|");
			out.write(this.getCheckOut() + "|");
			out.write(this.getPrice() + "|");
			out.write(this.getPaymentsDate() + "|");
			out.newLine();
		} catch (Exception e) {
			System.out.println("Lỗi khi ghi gile");
		}
	}

	public boolean readFile(String s) throws ParseException {

		if (s != null) {
			// khi doc file doc toi dau |
			String[] inp = s.split("\\|");
			this.setId(Integer.parseInt(inp[0]));
			this.setMaNV(Integer.parseInt(inp[1]));
			this.setMaKH(Integer.parseInt(inp[2]));
			this.setMaPhong(Integer.parseInt(inp[3]));
			this.setMaDV(Integer.parseInt(inp[4]));
//			Date dateIn = f.parse(inp[5]);
			this.setCheckIn(inp[5]);
//			Date dateOut = f.parse(inp[6]);
			this.setCheckOut(inp[6]);
			this.setPrice(inp[7]);
//			Date date = f.parse(inp[8]);
			this.setPaymentsDate();
			return true;
		}
		return false;
	}
}