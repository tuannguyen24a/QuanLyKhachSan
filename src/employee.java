
public class employee extends human {
	private String maNV;
	private account account;

	public employee() {
	}

	public employee(String maNV, account account, String name, int age, String gender, String address,
			String phoneNumber) {
		super(name, age, gender, address, phoneNumber);
		this.maNV = maNV;
		this.account = account;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
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
		System.out.println("Mời nhập mã nhân viên: ");
		setMaNV(sc.nextLine());
	}

	@Override
	public void Xuat() {
		super.Xuat();
		System.out.println("Mã nhân viên: " + getMaNV());
	}

}
