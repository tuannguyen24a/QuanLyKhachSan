import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class listCustomer implements QL_KhachHang {
	protected List<customer> l_customer;
	public static final String FILE_customer = "./src/customer.txt";
	Scanner scan = new Scanner(System.in);

	public listCustomer(List<customer> l_customer) {
		this.l_customer = l_customer;
	}

	public listCustomer() {
		l_customer = new ArrayList<>();
	}

	public void docFile() throws IOException {
		BufferedReader nhap = null;
		try {
			nhap = new BufferedReader(new FileReader(FILE_customer));
			String s = null;
			do {
				s = nhap.readLine();
				customer u = new customer();
				if (u.docFile(s))
					l_customer.add(u);
			} while (s != null);
			nhap.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi khi doc file " + FILE_customer);
		}
	}
	
	public void ghiDeFile() throws  IOException {
		List<customer> tk = l_customer;
		BufferedWriter fileOut = new BufferedWriter(new FileWriter(FILE_customer)); 
			for (customer a : tk) {
				a.ghiFile(fileOut);
			}
	}

	public void ghiFile() throws IOException {
		BufferedWriter xuat = new BufferedWriter(new FileWriter(FILE_customer));
		for (customer a : l_customer)
			a.ghiFile(xuat);
		xuat.close();
	}
	
	public int getNewMaKH() {
        int newid = 0;
        if (l_customer.isEmpty() == true) {
            return 0;
        } else {
            for (customer customer : l_customer) {
                if (Integer.valueOf(customer.getMaKH()) > newid) {
                    newid = Integer.valueOf(customer.getMaKH());
                }
            }
        }
        return newid + 1;
    }
	public void themKH(int a) throws IOException {
		System.out.println("\n=============.Thêm khách hàng.=============");
		System.out.println("Nhập số khách hàng cần thêm: ");
		int soKH = Integer.parseInt(scan.nextLine());
		for(int i = 0; i < soKH; i++) {
			customer cus = new customer();
			cus.setMaPhong(a);
			cus.Nhap();
			cus.setMaKH(this.getNewMaKH());
			l_customer.add(cus);
		}
		this.ghiFile();
	}


	public void headerAdmin() {
		System.out.println(" __________________________________________________________________________________________________________________________");
        //                         1          2            					3           4            5           				 6           7                         9               10         11
        System.out.println("|   ID   |           HỌ VÀ TÊN          |  TUỔI  |   GIỚI TÍNH  |            ĐỊA CHỈ           |      SĐT      |  MÃ PHÒNG |");
        System.out.println("|________|______________________________|________|______________|______________________________|_______________|___________|");
	}
	public void foooterAdmin () {
		System.out.println("|________|______________________________|________|______________|______________________________|_______________|___________|");

	}
	public void header() {
		System.out.println(" ____________________________________________________________");
        //                         1          2            					3           4            5           				 6           7                         9               10         11
        System.out.println("|   ID   |           HỌ VÀ TÊN          |  TUỔI  |  MÃ PHÒNG |");
        System.out.println("|________|______________________________|________|___________|");
	}
	public void foooter () {
		System.out.println("|________|______________________________|________|___________|");

	}
	public void danhSachKhachHang () {
		header();
		 for(customer customer : l_customer) {
		        System.out.printf( 
		                    "|%-8d|%-30s|%-8d|%-11d|\n"
		            , customer.getMaKH(),
		            customer.getName(),
		            customer.getbirth(),
		            customer.getMaPhong()
		        );
		        foooter();
		        }
	}
	public void thongTinKhachHang() {
		headerAdmin();
        for(customer customer : l_customer) {
        System.out.printf( 
                    "|%-8d|%-30s|%-8d|%-14s|%-30s|%-15s|%-11d|\n"
            , customer.getMaKH(),
            customer.getName(),
            customer.getbirth(),
            customer.getGender(),
            customer.getAddress(),
            customer.getPhoneNumber(),
            customer.getMaPhong()
        );
        foooterAdmin();
        }
}
	public boolean timKiemKhachTheoMaKH (int id) {
		header();
		int k = 0;
		for(Iterator<customer> it = l_customer.iterator(); it.hasNext();) {
			customer customer = it.next();
			if(!(customer.getMaKH() == id)) {
				continue;
			} else {
				 System.out.printf( 
				            //   		1     2  3     4     5   6    7      
				                    "|%-8d|%-30s|%-8d|%-11d|\n"
				            , customer.getMaKH(),
				            customer.getName(),
				            customer.getbirth(),
				            customer.getMaPhong());
				 k++; 
			}
		}
		foooter();
		if(k!=0) return true;
		return false;
	}
	public boolean thongTinKhachTheoMaKH (int id) {
		headerAdmin();
		int k = 0;
		for(Iterator<customer> it = l_customer.iterator(); it.hasNext();) {
			customer customer = it.next();
			if(!(customer.getMaKH() == id)) {
				continue;
			} else {
				 System.out.printf( 
		                    "|%-8d|%-30s|%-8d|%-14s|%-30s|%-15s|%-11d|\n"
		            , customer.getMaKH(),
		            customer.getName(),
		            customer.getbirth(),
		            customer.getGender(),
		            customer.getAddress(),
		            customer.getPhoneNumber(),
		            customer.getMaPhong()
		        );
				 k++; 
			}
		}
		foooterAdmin();
		if(k!=0) return true;
		return false;
	}
	public boolean timKiemKhachTheoMaPhong (int id) {
		header();
		int k = 0;
		for(Iterator<customer> it = l_customer.iterator(); it.hasNext();) {
			customer customer = it.next();
			if(!(customer.getMaPhong() == id)) {
				continue;
			} else {
				 System.out.printf( 
				                    "|%-8d|%-30s|%-8d|%-11d|\n"
				            , customer.getMaKH(),
				            customer.getName(),
				            customer.getbirth(),
				            customer.getMaPhong());
				 k++;
			}
		}
		foooter();
		if(k!=0) return true;
		return false;
	}
	
	public boolean thongTinKhachTheoMaPhong (int id) {
		headerAdmin();
		int k = 0;
		for(Iterator<customer> it = l_customer.iterator(); it.hasNext();) {
			customer customer = it.next();
			if(!(customer.getMaPhong() == id)) {
				continue;
			} else {
				System.out.printf( 
	                    "|%-8d|%-30s|%-8d|%-14s|%-30s|%-15s|%-11d|\n"
	            , customer.getMaKH(),
	            customer.getName(),
	            customer.getbirth(),
	            customer.getGender(),
	            customer.getAddress(),
	            customer.getPhoneNumber(),
	            customer.getMaPhong()
	        );
				 k++;
			}
		}
		foooterAdmin();
		if(k!=0) return true;
		return false;
	}
	
	public boolean timKiemKhachTheoTen (String name) {
		header();
		int k = 0;
		for(Iterator<customer> it = l_customer.iterator(); it.hasNext();) {
			customer customer = it.next();
			if(!(StringUtils.removeAccent(customer.getName().toLowerCase()).contains(StringUtils.removeAccent(name).toLowerCase()))) {
				continue;
			} else {
				 System.out.printf( 
				            //   		1     2  3     4     5   6    7      
				                    "|%-8d|%-30s|%-8d|%-11d|\n"
				            , customer.getMaKH(),
				            customer.getName(),
				            customer.getbirth(),
				            customer.getMaPhong());
				 k++;
			}
		}
		foooter();
		if(k!=0) return true;
		return false;
	}
	
	public boolean thongTinKhachTheoTen (String name) {
		headerAdmin();
		int k = 0;
		for(Iterator<customer> it = l_customer.iterator(); it.hasNext();) {
			customer customer = it.next();
			if(!(StringUtils.removeAccent(customer.getName().toLowerCase()).contains(StringUtils.removeAccent(name).toLowerCase()))) {
				continue;
			} else {
				System.out.printf( 
			            "|%-8d|%-30s|%-8d|%-14s|%-30s|%-15s|%-11d|\n"
			    , customer.getMaKH(),
			    customer.getName(),
			    customer.getbirth(),
			    customer.getGender(),
			    customer.getAddress(),
			    customer.getPhoneNumber(),
			    customer.getMaPhong()
			);
				 k++;
			}
		}
		foooterAdmin();
		if(k!=0) return true;
		return false;
	}
	public void xapSep() {
		
	}
	public void sapXeptheoMa(int k){
        //sap xep theo so tu nho toi lon
        if ( k==0 ){
            Collections.sort(l_customer, customer::maTangdan);
        }
        //tu lon toi nho
        else{
            Collections.sort(l_customer, customer::maGiamdan);
        }
    }
	
	 public void sapXepTheoTuoi(int k){
	        //sap xep theo so tu nho toi lon
	        if ( k == 0 ){
	            Collections.sort(l_customer, customer::tuoiTangdan);
	        }
	        //tu lon toi nho
	        else{
	            Collections.sort(l_customer, customer::tuoiGiamdan);
	        }
	    }
	 public void sapXepTheoMaPhong(int k){
	        //sap xep theo so tu nho toi lon
	        if ( k==0 ){
	            Collections.sort(l_customer, customer::maPhongTangdan);
	        }
	        //tu lon toi nho
	        else{
	            Collections.sort(l_customer, customer::maPhongGiamdan);
	        }
	    }
	 
	 public String getName(int id) {
		 int k = 0;
			for(Iterator<customer> it = l_customer.iterator(); it.hasNext();) {
				customer customer = it.next();
				if(!(customer.getMaKH() == id)) {
					continue;
				} else {
					 k++;
				}
				if(k!=0) return customer.getName();
			}
			
			return "Ko tìm thấy tên";
		} 
	 
	 public int getMaKH(int id) {
		 int k = 0;
			for(Iterator<customer> it = l_customer.iterator(); it.hasNext();) {
				customer customer = it.next();
				if(!(customer.getMaKH() == id)) {
					continue;
				} else {
					 k++;
				}
				if(k!=0) return customer.getMaKH();
			}
			
			return 0;
		} 
	 
	public static void main(String[] args) throws IOException {
		listCustomer customer = new listCustomer();
		customer.docFile();
	}
}
