import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class listAccount {
	protected List<account> l_account;
	public static final String FILE_account = "./src/account.txt";
	Scanner scan = new Scanner(System.in);

	public listAccount(List<account> l_account) {
		this.l_account = l_account;
	}

	public listAccount() {
		l_account = new ArrayList<>();
	}

	public void docFile() throws IOException {
		BufferedReader nhap = null;
		try {
			nhap = new BufferedReader(new FileReader(FILE_account));
			String s = null;
			do {
				s = nhap.readLine();
				account u = new account();
				if (u.docFile(s))
					l_account.add(u);
			} while (s != null);
			nhap.close();
		} catch (Exception e) {
			System.out.println("Loi khi doc file " + FILE_account);
		}
	}

	public void addAccount(String matk, String quyen) {
		System.out.println("\n=============.Create a new Account.=============");
		account temp = new account();
		temp.setMa_tk(matk);
		temp.setQuyen(quyen);
		do {
			System.out.println("enter usename: ");
			temp.setUsername(scan.nextLine());
		} while (checkUser(temp.getUsername()));
		System.out.println("enter password: ");
		temp.setPassword(scan.nextLine());
		l_account.add(temp);
	}

	public boolean check_existId(String id) {
		for (Iterator<account> it = l_account.iterator(); it.hasNext();) {
			account e = it.next();
			if (e.getMa_tk().compareToIgnoreCase(id) == 0) {
				System.out.println("Ma tai khoan da ton tai");
				return true;
			}
		}
		return false;
	}

	public boolean checkUser(String user) {
		for (Iterator<account> it = l_account.iterator(); it.hasNext();) {
			account e = it.next();
			if (e.getUsername().compareToIgnoreCase(user) == 0) {
				System.out.println("username da ton tai");
				return true;
			}
		}
		return false;
	}

//	public void ghiThem(ArrayList<account> dstk) throws FileNotFoundException, IOException {
//		for (account tk : dstk) {
//			try (DataOutputStream fileOut = new DataOutputStream(new FileOutputStream(FILE_account, true))) {
//
//				tk.ghiFile(fileOut);
//				fileOut.close();
//			} catch (IOException e) {
//				System.err.println("Loi khi GHI FILE " + FILE_account + "!");
//			}
//		}
//	}
//
	public void ghiDeFile() throws  IOException {
		List<account> tk = l_account;
		BufferedWriter fileOut = new BufferedWriter(new FileWriter(FILE_account)); 
			for (account a : tk) {
				a.ghiFile(fileOut);
			}
	}

	 public void deleteAll(){
	        l_account.removeAll(l_account);
	    }
	 
	public void ghiFile() throws IOException {
		BufferedWriter xuat = new BufferedWriter(new FileWriter(FILE_account));
		for (account a : l_account)
			a.ghiFile(xuat);
		xuat.close();
	}

	public int getNewmatk() {
		int newid = 0;
		if (l_account.isEmpty() == true) {
			return 0;
		} else {
			for (account tk : l_account) {
				if (Integer.valueOf(tk.getMa_tk()) > newid) {
					newid = Integer.valueOf(tk.getMa_tk());
				}
			}
		}
		return newid + 1;
	}

//
//	public void suaTheoMa() {
//		System.out.println("Nhập mã tài khoản:");
//		int ma_tk = scan.nextInt();
//		boolean isUpdate = false;
//		ArrayList<account> tkedit = new ArrayList();
//		for (account tk : l_account) {
//			if (Integer.valueOf(tk.getMa_tk()) == ma_tk) {
//				tk.Nhap();
//			}
//			tkedit.add(tk);
//		}
//		System.out.println();
//		try {
//			ghiDe();
//			isUpdate = true;
//
//		} catch (IOException ex) {
//
//			Logger.getLogger(listAccount.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		isUpdate = true;
//		if (isUpdate == true) {
//			System.out.println("Sửa thành công.");
//		} else {
//			System.out.println("Lỗi khi sửa.");
//		}
//	}
//
	public void deleteAccount(){
		System.out.println("Nhập username cần xóa: ");
		String user = scan.nextLine();
		boolean isDelete = false;
        for (Iterator<account> it = l_account.iterator(); it.hasNext();) {
            account u = it.next();
            if(u.getUsername().compareToIgnoreCase(user)==0){
                it.remove();
               try {
            	   ghiFile();
            	   isDelete = true;
               } catch (IOException e) {
            	   System.err.println("Loi khi GHI FILE " + FILE_account + "!");
               }
               
            }
        }
        if (isDelete == true) {
			System.out.println("xóa thành công.");
		} else {
			System.out.println("lỗi khi xóa.");
		}
    }
	
	public void forgetPass(){
		System.out.println("Nhập username: ");
		String user = scan.nextLine();
		boolean isForget = false;
        for (Iterator<account> it = l_account.iterator(); it.hasNext();) {
            account u = it.next();
            if(u.getUsername().compareToIgnoreCase(user)==0){
                System.out.printf("Enter new password:");
                u.setPassword(scan.nextLine());
                try {
             	   ghiFile();
             	   isForget = true;
                } catch (IOException e) {
             	   System.err.println("Loi khi GHI FILE " + FILE_account + "!");
                }
            }
        }
        if (isForget == true) {
			System.out.println("Đổi thành công.");
		} else {
			System.out.println("lỗi khi đổi mật khẩu.");
		}
    }
	
	 public void changePass(String id){
		 boolean flag = false;
	        for (Iterator<account> it = l_account.iterator(); it.hasNext();) {
	            account u = it.next();
	            if(u.getMa_tk().compareToIgnoreCase(id)==0){
	                System.out.printf("Enter new password:");
	                u.setPassword(scan.nextLine());
	                try {
	             	   ghiFile();
	             	   flag = true;
	                } catch (IOException e) {
	             	   System.err.println("Loi khi GHI FILE " + FILE_account + "!");
	                }
	            }
	        }
	        if (flag == true) {
    			System.out.println("xóa thành công.");
    		} else {
    			System.out.println("lỗi khi xóa.");
    		}
	    }
	
	public void xuat() {
		System.out.println(" __________________________________________");
		System.out.println("|   Id   |   Username     |      quyen     |");
		for (account a : l_account)
			System.out.printf("|   %-5s| %-13s  | %-14s |\n", a.getMa_tk(), a.getUsername(), a.getQuyen());
		System.out.println("|________|________________|________________|");
	}

//
//	public void them(account tk) throws IOException {
//		ArrayList<account> add = new ArrayList();
//		add.add(tk);
//		ghiThem(add);
//
//	}
//
//	public void xoaTheoMa() {
//		System.out.println("Nhập mã tài khoản xóa:");
//		int ma = scan.nextInt();
//		boolean isDelete = false;
//		for (account tk1 : l_account) {
//			if (ma == Integer.valueOf(tk1.getMa_tk())) {
//				l_account.remove(tk1);
//				try {
//					ghiDe();
//					isDelete = true;
//					break;
//				} catch (IOException ex) {
//
//					Logger.getLogger(listAccount.class.getName()).log(Level.SEVERE, null, ex);
//				}
//				isDelete = true;
//
//			}
//		}
//		if (isDelete == true) {
//			System.out.println("xóa thành công.");
//		} else {
//			System.out.println("lỗi khi xóa.");
//		}
//	}
//
	public account log() throws IOException{
		 System.out.println(
	                " _______________________________________________ \n" +
	                "|                                               |\n" +
	                "|                   WELCOME                     |\n" +
	                "|_______________________________________________|\n" +
	                "|                                               |\n" +
	                "|                    Login                      |\n" +
	                "|_______________________________________________|\n"
	        );
		 
        account temp = new account();
        do {
            temp.setInfo();
            for (Iterator<account> it = l_account.iterator(); it.hasNext();) {
                account u = it.next();
                if(u.getUsername().compareToIgnoreCase(temp.getUsername())==0 && u.getPassword().compareToIgnoreCase(temp.getPassword())==0){
                   System.out.printf(
                            " _______________________________________________\n" +
                            "|                                               |\n" +
                            "|   ID: %-7s CHUCVU:  %-14s         |\n" +
                            "|_______________________________________________|\n",u.getMa_tk(),u.getQuyen()
                    );
                    temp = u;
                }
            }   
        } while(temp.getQuyen()==null);
        return temp;
    }
	
	public void Menu_END(){
        System.out.println(
                " _______________________________________________ \n" +
                "|                                               |\n" +
                "|      			 					         |\n" +
                "|                   GOOD BYE					 |\n" +
                "|                                               |\n" +
                "|_______________________________________________|");
    }
	
	public String getName(int id) {
		 int k = 0;
			for(Iterator<account> it = l_account.iterator(); it.hasNext();) {
				account account = it.next();
				if(!(Integer.parseInt(account.getMa_tk()) == id)) {
					continue;
				} else {
//					System.out.printf( 
//				            "|%-8d|%-30s|%-8d|%-14s|%-30s|%-15s|%-11d|\n"
//				    , customer.getMaKH(),
//				    customer.getName(),
//				    customer.getbirth(),
//				    customer.getGender(),
//				    customer.getAddress(),
//				    customer.getPhoneNumber(),
//				    customer.getMaPhong()
//				);
					 k++;
				}
				if(k!=0) return account.getUsername();
			}
			
			return "Ko tìm thấy tên";
		} 
	
	public static void main(String[] args) throws IOException {
		listAccount account = new listAccount();
		account.docFile();
		account.xuat();
//		account.docFile();
//		account.xuat();
//		account.addAccount("12", "admin");
//		account.ghiFile();
//		
		//account.log();
//		menu menu = new menu();
//		menu.readFile();
//		menu.mainMenu();
//		menu.writeFile();
//		account account2 = new account("0", "hai", "1234", "1");
//		account2.Xuat();
	}
}
