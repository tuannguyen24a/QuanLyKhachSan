import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


public class menu {
	public static int k;
	public static int capbac;
	static private String id;
	
	static listAccount list_user = new listAccount();
	static listRoom list_room = new listRoom();
	static listCustomer list_customer = new listCustomer();
	static listService list_service = new listService();
	static listBill list_Bill = new listBill();
	static booking book = new booking();
	
	static Scanner sc =  new Scanner(System.in);
	
	public static void readFile() throws IOException, ParseException {
		list_user.docFile();
		list_room.docFile();
		list_customer.docFile();
		list_service.docFile();
		list_Bill.docFile();
	}
	
	public static void writeFile() throws IOException {
		list_user.ghiFile();
		list_room.ghiFile();
	}
	
	public static void locTheoGiaPhong () throws IOException {
		boolean exit = false;
		do {
			System.out.printf("0. Exit\n"
					+ "1. Dưới 500.000\n"
					+ "2. Từ 500.000 ~ 1.000.000\n"
					+ "3. Từ 1.000.000 ~ 2.000.000\n"
					+ "4. Trở về\n");
			System.out.println("--------------------------------");
			System.out.print("Lựa chọn: ");
				k = (Integer.parseInt(sc.nextLine()));
	        switch (k) {
	            case 0:
	                System.exit(0);
	            case 1:
	            	list_room.timPhongTheoGiaDuoi500();
	                break;
	            case 2:
	            	list_room.timPhongTheoGiaTu500Den1tr();
	                break;
	            case 3:
	            	list_room.timPhongTheoGiaTu1trDen2tr();
	                break;
	            case 4:
	            	menuPhong();
	                break;
	            default:
	                System.err.println("Nhập sai vui lòng nhập lại!");
	                menuPhong();
	                break;
	        	}
			} while (!exit);
	        mainMenu();
	}
	
	public static void menuTimPhong () throws IOException {
		Boolean exit = false;
		do {
			System.out.println("----------.MENU TÌM PHÒNG.---------");
		System.out.printf("0. Exit\n"
				+ "1. Tìm theo mã phòng\n"
				+ "2. Tìm theo loại phòng\n"
				+ "3. Tìm theo sức chứa\n"
				+ "4. Lọc theo giá\n"
				+ "5. Trở về\n");
		System.out.println("--------------------------------");
		System.out.print("Lựa chọn: ");
			k = (Integer.parseInt(sc.nextLine()));
        switch (k) {
            case 0:
                System.exit(0);
            case 1:
            	System.out.println("Nhập mã phòng: ");
            	if(list_room.timPhongTheoMa(Integer.parseInt(sc.nextLine()))) {
            		System.out.println("Thành công");
            	} else {
					System.out.println("Mã phòng không tồn tại");
				}
                break;
            case 2:
            	System.out.println("Nhập loại phòng: ");
            	if ( list_room.timPhongTheoLoai(sc.nextLine())) {
					System.out.println("Thành công");
				} else {
					System.out.println("Loại phòng không tồn tại");
				}
               
                break;
            case 3:
            	System.out.println("Nhập số lượng: ");
            	if(list_room.timPhongTheoSucChua(Integer.parseInt(sc.nextLine()))) {
            		System.out.println("Thành công");
            	} else {
					System.out.println("Số lượng từ 1 ~ 6");
				}
                break;
            case 4:
            	locTheoGiaPhong();
                break; 
            case 5:
            	mainMenu();
                break;
            default:
                System.err.println("Nhập sai vui lòng nhập lại!");
                menuTaiKhoan();
                break;
        	}
		} while (!exit);
        mainMenu();
	}
	
	public static void menuPhong() throws IOException {
		Boolean exit = false;
		do {
			System.out.println("----------.MENU QUẢN LÝ PHÒNG.---------");
		System.out.printf("0. Exit\n"
				+ "1. Danh sách phòng\n"
				+ "2. Danh sách phòng trống\n"
				+ "3. Danh sách phòng đã đặt\n"
				+ "4. Tìm phòng\n"
				+ "5. Đặt phòng\n"
				+ "6. Trở về\n");
			System.out.println("--------------------------------");
			System.out.print("Lựa chọn: ");
			k = (Integer.parseInt(sc.nextLine()));
        switch (k) {
            case 0:
                System.exit(0);
            case 1:
            	list_room.xuatDanhSachPhong();
                break;
            case 2:
                list_room.xuatDanhSachPhongTrong();
                break;
            case 3:
            	list_room.xuatDanhSachPhongDat();
                break;
            case 4:
            	menuTimPhong();
                break;
            case 5:
    			try {
    				System.out.println("Chọn phòng muốn đặt: ");
    				int a = Integer.parseInt(sc.nextLine());
    				list_customer.themKH(a);
    				list_Bill.themHoaDon(a, Integer.parseInt(id), list_customer.getNewMaKH() - 1 );
    			} catch (NumberFormatException | IOException | ParseException e) {
    				e.printStackTrace();
    			}
                break;
            case 6:
            	mainMenu();
                break;
            default:
                System.err.println("Nhập sai vui lòng nhập lại!");
                menuTaiKhoan();
                break;
        	}
		} while (!exit);
        mainMenu();
	}
	
	public static void menuDichVu() throws IOException {
		Boolean exit = false;
		do {
		System.out.println("----------.MENU QUẢN LÝ DỊCH VỤ.---------");
		System.out.printf("0. Trở về\n"
				+ "1. Danh sách dịch vụ\n"
				+ "2. Chọn dịch vụ\n");
			System.out.println("--------------------------------");
			System.out.print("Lựa chọn: ");
			k = (Integer.parseInt(sc.nextLine()));
        switch (k) {
            case 0:
                mainMenu();
            case 1:
            	list_service.danhSachDichVu();
                break;
            case 2:
                break;
            default:
                System.err.println("Nhập sai vui lòng nhập lại!");
                mainMenu();
                break;
        	}
		} while (!exit);
        mainMenu();
	}
	
	public static void menuTimKhach () throws IOException {
		Boolean exit = false;
		do {
		System.out.printf("0. Trở về\n"
				+ "1. Tìm khách hàng theo mã khách hàng\n"
				+ "2. Tìm khách hàng theo mã phòng\n"
				+ "3. Tìm kiếm khách hàng theo tên\n");
			if(capbac == 1) 
				System.out.printf("4. Thông tin khách hàng theo mã\n"
				+ "5. Thông tin khách hàng theo phòng\n"
				+ "6. Thông tin khách hàng theo tên\n");
		if (capbac != 1)
			do {
				k = (Integer.parseInt(sc.nextLine()));
				if (k > 3 || k < 0)
					System.out.println("Vui lòng nhập lại !!");
			} while (k > 3 || k < 0);
		else {
			System.out.println("--------------------------------");
			System.out.print("Lựa chọn: ");
			k = (Integer.parseInt(sc.nextLine()));
		}
			
        switch (k) {
            case 0:
                menuKhachHang();
            case 1:
            	System.out.println("Nhập mã khách hàng: ");
            	if(list_customer.timKiemKhachTheoMaKH(Integer.parseInt(sc.nextLine()))) {
            		System.out.println("Thành công");
            	}else {
					System.out.println("Mã khách hàng không tồn tại");
				}
                break;
            case 2:
            	System.out.println("Nhập mã phòng: ");
            	if(list_customer.timKiemKhachTheoMaPhong(Integer.parseInt(sc.nextLine()))){
            		System.out.println("Thành công");
            	} else {
					System.out.println("Mã khách hàng không tồn tại");
				}
                 break;
            case 3:
            	System.out.println("Nhập tên khách hàng cần tìm: ");
            	if(list_customer.timKiemKhachTheoTen(sc.nextLine())) {
            		System.out.println("Thành công");
            	} else {
            		System.out.println("Không có khách hàng tên" + sc.nextLine());
				}
                break;
            case 4:
            	System.out.println("Nhập mã khách hàng: ");
            	if(list_customer.thongTinKhachTheoMaKH(Integer.parseInt(sc.nextLine()))) {
            		System.out.println("Thành công");
            	}else {
					System.out.println("Mã khách hàng không tồn tại");
				}
                break;
            case 5:
            	System.out.println("Nhập mã phòng: ");
            	if(list_customer.thongTinKhachTheoMaPhong(Integer.parseInt(sc.nextLine()))){
            		System.out.println("Thành công");
            	} else {
					System.out.println("Mã khách hàng không tồn tại");
				}
                 break;
            case 6:
            	System.out.println("Nhập tên khách hàng cần tìm: ");
            	if(list_customer.thongTinKhachTheoTen(sc.nextLine())) {
            		System.out.println("Thành công");
            	} else {
            		System.out.println("Không có khách hàng tên" + sc.nextLine());
				}
                break;
            default:
                System.err.println("Nhập sai vui lòng nhập lại!");
                menuTaiKhoan();
                break;
        	}
		} while (!exit);
        mainMenu();
}
	public static void menuSapXepKhach () throws IOException {
		Boolean exit = false;
		do {
		System.out.printf("0. Trở về\n"
				+ "1. Sắp xếp theo mã khách hàng\n"
				+ "2. Sắp xếp theo tuổi khách hàng\n"
				+ "3. Sắp xếp theo mã phòng\n");
			System.out.println("--------------------------------");
			System.out.print("Lựa chọn: ");
			k = (Integer.parseInt(sc.nextLine()));
        switch (k) {
            case 0:
                menuKhachHang();
            case 1:
            	System.out.println("1. Mã tăng dần\n"
            			+ "2. Mã giảm dần\n");
            	int choose = Integer.parseInt(sc.nextLine());
            	list_customer.sapXeptheoMa(choose - 1);
                break;
            case 2:
            	System.out.println("1. Tuổi tăng dần\n"
            			+ "2. Tuổi giảm dần\n");
            	int choose2 = Integer.parseInt(sc.nextLine());
                list_customer.sapXepTheoTuoi(choose2 - 1);
                break;
            case 3:
            	System.out.println("1. Mã phòng tăng dần\n"
            			+ "2. Mã phòng giảm dần\n");
            	int choose3 = Integer.parseInt(sc.nextLine());
            	list_customer.sapXepTheoMaPhong(choose3 - 1);
                break;
            default:
                System.err.println("Nhập sai vui lòng nhập lại!");
                menuKhachHang();
                break;
        	}
        list_customer.danhSachKhachHang();
		} while (!exit);
        menuKhachHang();
	}
	
	public static void menuKhachHang() throws IOException {
		Boolean exit = false;
		do {
		System.out.printf("0. Trở về\n"
				+ "1. Danh sách khách hàng\n"
				+ "2. Tìm kiếm khách hàng\n"
				);
			if(capbac == 1) 
				System.out.printf("3. Sắp xếp\n"
						+ "4. Thông tin chi tiết khách hàng\n");
		if (capbac != 1)
			do {
				k = (Integer.parseInt(sc.nextLine()));
				if (k > 2 || k < 0)
					System.out.println("Vui lòng nhập lại !!");
			} while (k > 2 || k < 0);
		else {
			System.out.println("--------------------------------");
			System.out.print("Lựa chọn: ");
			k = (Integer.parseInt(sc.nextLine()));
		}
        switch (k) {
            case 0:
                mainMenu();
            case 1:
            	list_customer.danhSachKhachHang();
                break;
            case 2:
                menuTimKhach();
                break;
            case 3:
            	menuSapXepKhach();
                break;
            case 4:
            	list_customer.thongTinKhachHang();
                break;
            case 5:
            	mainMenu();;
                break;
            default:
                System.err.println("Nhập sai vui lòng nhập lại!");
                menuTaiKhoan();
                break;
        	}
		} while (!exit);
        mainMenu();
}

	
	public static void menuTaiKhoan() throws IOException {
		Boolean exit = false;
		do {
			System.out.println("--------.MENU QUẢN LÝ TÀI KHOẢN.--------");
		System.out.printf("0. Trở về\n"
				+ "1. Đổi mật khẩu\n");
		if(capbac == 1)
		System.out.println("2. Xóa tài khoản\n"
				+ "3. Quên mật khẩu\n"
				+ "4. Hiển thị danh sách tài khoản\n"
				+ "5. trở về\n");
		if (capbac != 1)
			do {
				k = (Integer.parseInt(sc.nextLine()));
				if (k > 2 || k < 0)
					System.out.println("Vui lòng nhập lại !!");
			} while (k > 2 || k < 0);
		else {
			System.out.println("--------------------------------");
			System.out.print("Lựa chọn: ");
			k = (Integer.parseInt(sc.nextLine()));
		}
			
        switch (k) {
            case 0:
                mainMenu();
            case 1:
            	list_user.changePass(id);
                break;
            case 2:
                list_user.deleteAccount();
                break;
            case 3:
            	list_user.forgetPass();
                break;
            case 4:
            	list_user.xuat();
                break;
            case 5:
            	mainMenu();
                break;
            default:
                System.err.println("Nhập sai vui lòng nhập lại!");
                menuTaiKhoan();
                break;
        	}
		} while (!exit);
        mainMenu();
}
	
	public static void menuHoaDon() throws IOException {
		Boolean exit = false;
		do {
			System.out.println("--------.MENU QUẢN LÝ HÓA ĐƠN.--------");
			System.out.printf("0. Trở về\n"
					+ "1. Danh sách hóa đơn\n"
					+ "2. Tính tiền\n");
			System.out.println("--------------------------------");
			System.out.print("Lựa chọn: ");
			k = (Integer.parseInt(sc.nextLine()));
        switch (k) {
            case 0:
                mainMenu();
            case 1:
			try {
				list_Bill.readFile();
				list_Bill.danhSachHoaDon();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
            case 2:
                break;
            default:
                System.err.println("Nhập sai vui lòng nhập lại!");
                menuHoaDon();
                break;
        	}
		} while (!exit);
        mainMenu();

	}

	public static void mainMenu() throws IOException {
		while (true) {
			System.out.println("-------------.Menu.-------------");
			System.out.println("1. Quản lý phòng");
			System.out.println("2. Quản lý dịch vụ");
			System.out.println("3. Quản lý hóa đơn");
			System.out.println("4. Quản lý khách hàng");
			System.out.println("5. Quản lý tài khoản");
			System.out.println("6. Thống kê");
			System.out.println("7. Đổi mật khẩu");
			System.out.println("8. Đăng xuất");
			System.out.println("0. Thoát");
			System.out.println("--------------------------------");
			System.out.print("Lựa chọn: ");
			
			switch ((Integer.parseInt(sc.nextLine()))) {
			case 1:
//				try {
//					list_Bill.danhSachHoaDon();
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
				menuPhong();
				break;
			case 2:
				menuDichVu();
				break;
			case 3:
				menuHoaDon();
				break;
			case 4:
				menuKhachHang();
				break;
			case 5:
				menuTaiKhoan();
				break;
			case 6:
				//Thong ke
				break;
			case 7:
				list_user.changePass(id);
				break;
			case 8:
				
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Nhap sai! Menu (0 - 9)");
				mainMenu();
				break;
			}
		}
	}
	public static void Main(String id, String position) throws IOException, ParseException {
		readFile();
		menu.id = id;
		if (position.equalsIgnoreCase("Admin"))
			menu.capbac = 1;
		else {
			menu.capbac = 2;
		}
		mainMenu();

	}
}
