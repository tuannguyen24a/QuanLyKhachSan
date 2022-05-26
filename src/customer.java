import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class customer extends human {
	private int maKH;
	private int maPhong;

	public customer() {
	}

	public customer(int maKH, String name, int birth, String gender, String address, String phoneNumber, int maPhong) {
		super(name, birth, gender, address, phoneNumber);
		this.maKH = maKH;
		this.maPhong = maPhong;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public int getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(int maPhong) {
		this.maPhong = maPhong;
	}

	@Override
	public void Nhap() {
//		setMaPhong(Integer.parseInt(sc.nextLine())); 
		super.Nhap();
	}

	@Override
	public void Xuat() {
		System.out.println("Mã khách hàng: " + getMaKH());
		super.Xuat();
	}

	public void display() {
		System.out.println(
				" __________________________________________________________________________________________________________________________");
		// 1 2 3 4 5 6 7 9 10 11
		System.out.println(
				"|   ID   |           HO VA TEN          |  TUOI  |   GIOI TINH  |            ADDRESS           |     PHONE     |  MA PHONG |");
		System.out.println(
				"|________|______________________________|________|______________|______________________________|_______________|___________|");
		System.out.printf(
				// 1 2 3 4 5 6 7
				"|%-9d|%-30s|%-8d|%-8s|%-30s|%-15d|%-11d|\n", this.getMaKH(), super.getName(), super.getbirth(),
				super.getGender(), super.getAddress(), super.getPhoneNumber(), this.getMaPhong());
		System.out.println(
				"|________|______________________________|________|______________|______________________________|_______________|___________|");
		System.out.println("");
	}

	public void ghiFile(BufferedWriter out) throws IOException {
		out.write(this.getMaKH() + "|");
		out.write(super.getName() + "|");
		out.write(super.getbirth() + "|");
		out.write(super.getGender() + "|");
		out.write(super.getAddress() + "|");
		out.write(super.getPhoneNumber() + "|");
		out.write(this.getMaPhong() + "|");
		out.newLine();
	}

	public boolean docFile(String s) {
		if (s != null) {
			String[] inp = s.split("\\|");
			this.setMaKH(Integer.parseInt(inp[0]));
			super.setName(inp[1]);
			super.setbirth(Integer.parseInt(inp[2]));
			super.setGender(inp[3]);
			super.setAddress(inp[4]);
			super.setPhoneNumber(inp[5]);
			this.setMaPhong(Integer.parseInt(inp[6]));
			return true;
		}
		return false;
	}

	public static int maTangdan(customer a, customer b) {
		if (a.getMaKH() < b.getMaKH()) {
			return -1;
		} else {
			if (a.getMaKH() == b.getMaKH()) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	public static int maGiamdan(customer a, customer b) {
		if (a.getMaKH() > b.getMaKH()) {
			return -1;
		} else {
			if (a.getMaKH() == b.getMaKH()) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	public static int tuoiTangdan(customer a, customer b) {
		if (a.getbirth() < b.getbirth()) {
			return -1;
		} else {
			if (a.getbirth() == a.getbirth()) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	public static int tuoiGiamdan(customer a, customer b) {
		if (a.getbirth() > b.getbirth()) {
			return -1;
		} else {
			if (a.getbirth() == a.getbirth()) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	public static int maPhongTangdan(customer a, customer b) {
		if (a.getMaPhong() < b.getMaPhong()) {
			return -1;
		} else {
			if (a.getMaPhong() == a.getMaPhong()) {
				return 0;
			} else {
				return 1;
			}
		}
	}

	public static int maPhongGiamdan(customer a, customer b) {
		if (a.getMaPhong() > b.getMaPhong()) {
			return -1;
		} else {
			if (a.getMaPhong() == a.getMaPhong()) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
