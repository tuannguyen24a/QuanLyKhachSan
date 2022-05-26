
public class admin extends human {
	private String maAdmin;
	private account account;

	public admin() {
		super();
	}

	public admin(String maAdmin, account account, String name, int age, String gender, String address,
			String phoneNumber) {
		super(name, age, gender, address, phoneNumber);
		this.maAdmin = maAdmin;
		this.account = account;
	}

	public String getmaAdmin() {
		return maAdmin;
	}

	public void setmaAdmin(String maAdmin) {
		this.maAdmin = maAdmin;
	}

	public account getAccount() {
		return account;
	}

	public void setAccount(account account) {
		this.account = account;
	}

	@Override
	public void Nhap() {
		super.Nhap();
		System.out.println("Nhập mã nhân viên: ");
		setmaAdmin(sc.nextLine());
	}

	@Override
	public void Xuat() {
		super.Xuat();
		System.out.println("Mã nhân viên: " + getmaAdmin());
	}

}
