import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class account {
	private String ma_tk;
	private String username;
	private String password;
	private String quyen;
	
	Scanner sc = new Scanner(System.in);
	public account() {

	}

	public account(String matk, String username, String password, String quyen) {
		this.ma_tk = matk;
		this.username = username;
		this.password = password;
		this.quyen = quyen;
	}

	public String getMa_tk() {
		return ma_tk;
	}

	public void setMa_tk(String ma_tk) {
		this.ma_tk = ma_tk;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	public void Xuat() {
		String role = ("0".equals(quyen)) ? "Nhân viên" : "Admin";
		System.out.println("Mã tài khoản: " + getMa_tk() + "\nTài khoản: " + getUsername() + "\nMật khẩu: "
				+ getPassword() + "\nQuyền :" + role);
	}

	public void setInfo (){
        System.out.printf("nhap username: ");
        this.setUsername(sc.nextLine());
        System.out.printf("nhap password: ");
        this.setPassword(sc.nextLine());
    }
	
	public void ghiFile(BufferedWriter out) throws IOException{
            out.write(this.getMa_tk() + "|");
            out.write(this.getUsername()+ "|");
            out.write(this.getPassword() + "|");
            out.write(this.getQuyen() + "|");
            out.newLine();
    }
    
    public boolean docFile(String s){ 
        if (s!=null){
            String[] inp = s.split("\\|");
            this.setMa_tk(inp[0]);
            this.setUsername(inp[1]);
            this.setPassword(inp[2]);
            this.setQuyen(inp[3]);
            return true;
        }
        return false;
    }
}
