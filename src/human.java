import java.util.Scanner;

public class human {
	private String name;
	private int birth;
	private String gender;
	private String address;
	private String phoneNumber;

	Scanner sc = new Scanner(System.in);

	public human() {
	}

	public human(String name, int birth, String gender, String address, String phoneNumber) {
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getbirth() {
		return birth;
	}

	public void setbirth(int birth) {
		this.birth = 2022 - birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void Nhap() {
		System.out.println("Mời nhập họ tên");
		setName(sc.nextLine());
		System.out.println("Mời nhập năm sinh");
		setbirth(Integer.parseInt(sc.nextLine()));
		System.out.println("Mời nhập giới tính");
		setGender(sc.nextLine());
		System.out.println("Mời nhập địa chỉ");
		setAddress(sc.nextLine());
		System.out.println("Mời nhập số điện thoại");
		setPhoneNumber(sc.nextLine());
	}

	public void Xuat() {
		System.out.println("Họ tên: " + getName() + "\nTuổi: " + getbirth() + "\nGiới tính: " + getGender() + "\nĐịa chỉ: " + getAddress()
		+ "\nSdt: " + getPhoneNumber());
	}

}
