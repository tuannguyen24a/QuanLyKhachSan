import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class listBill {
	protected List<bill> l_bill;
	public static final String FILE_bill = "./src/bill.txt";
	Scanner scan = new Scanner(System.in);
	static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static listAccount list_user = new listAccount();
	static listRoom list_room = new listRoom();
	static listCustomer list_customer = new listCustomer();
	static listService list_service = new listService();
	static booking booking = new booking();
	static customer customer = new customer();

	public void readFile() throws IOException {
		list_user.docFile();
		list_room.docFile();
		list_customer.docFile();
		list_service.docFile();
	}

	public listBill(List<bill> l_bill) {
		this.l_bill = l_bill;
	}

	public listBill() {
		l_bill = new ArrayList<>();
	}

	public void docFile() throws IOException, ParseException {
		BufferedReader nhap = null;
		try {
			nhap = new BufferedReader(new FileReader(FILE_bill));
			String s = null;
			do {
				s = nhap.readLine();
				bill u = new bill();
				if (u.readFile(s))
					l_bill.add(u);
			} while (s != null);
			nhap.close();
		} catch (IOException e) {
			e.printStackTrace();
//			System.out.println("Loi khi doc file " + FILE_bill);
		}
	}

	public void ghiFile() throws IOException {
		BufferedWriter xuat = new BufferedWriter(new FileWriter(FILE_bill));
		for (bill a : l_bill)
			a.writeFile(xuat);
		xuat.close();
	}

	public void header() {
		System.out.println(
				" ______________________________________________________________________________________________________________________________________________________");
		// 1 2 3 4 5 6 7
		System.out.println(
				"|Mã hóa đơn| Nhân viên |   Tên khách hàng   | Mã phòng |  Tên dịch vụ  |   Ngày nhận phòng   |   Ngày trả phòng    |     Giá     |   Ngày thanh toán   |");
		System.out.println(
				"|__________|___________|____________________|__________|_______________|_____________________|_____________________|_____________|_____________________|");
	}

	public void foooter() {
		System.out.println(
				"|__________|___________|____________________|__________|_______________|_____________________|_____________________|_____________|_____________________|");
	}

	public void themHoaDon(int maPhong, int maNV, int maKH) throws IOException, ParseException {
		bill bill = new bill();
		
		bill.setId(this.getNewMaHD());
		bill.setMaNV(maNV);
		bill.setMaKH(maKH);
		bill.setMaPhong(maPhong);
		bill.setMaDV(0);
		bill.setCheckIn(booking.getCheckInDate());
		bill.setCheckOut(booking.getCheckOutDate());
		bill.setPrice("");
		bill.setPaymentsDate();

		l_bill.add(bill);
		this.ghiFile();
	}

	public int getNewMaHD() {
		int newid = 0;
		if (l_bill.isEmpty() == true) {
			return 0;
		} else {
			for (bill bill : l_bill) {
				if (Integer.valueOf(bill.getId()) > newid) {
					newid = Integer.valueOf(bill.getId());
				}
			}
		}
		return newid + 1;
	}

	public void danhSachHoaDon() throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat f1 = new SimpleDateFormat("HH:mm:ss");
		header();
		for (bill bill : l_bill) {
//			String dayIn = f.format(bill.getCheckIn());
//			String hoursIn = f1.format(bill.getCheckIn());
//			String dayOut = f.format(bill.getCheckOut());
//			String hoursOut = f1.format(bill.getCheckOut());
			String str = f.format(bill.getPaymentsDate());
			String str1 = f1.format(bill.getPaymentsDate());
			System.out.printf(
					// 1 2 3 4 5 6 7
					"|%-10d|%-11s|%-20s|%-10d|%-15s|%-21s|%-21s|%-13s|%-10s %-10s|\n", bill.getId(),
					list_user.getName(bill.getMaNV()), list_customer.getName(bill.getMaKH()), bill.getMaPhong(),
					list_service.getName(bill.getMaDV()), bill.getCheckIn(), bill.getCheckOut(), bill.getPrice(), str, str1);
			foooter();
		}
	}

	public static void main(String[] args) throws IOException, ParseException {
		listBill bill = new listBill();
//		booking.tinhTien();
		bill.readFile();
		bill.docFile();
		bill.danhSachHoaDon();
	}
}
