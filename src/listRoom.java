
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class listRoom {
	protected List<room_type> l_room;
	private String FILE_room_type = "./src/room.txt";
	Scanner scan = new Scanner(System.in);
	
	public listRoom (List<room_type> l_room) {
		this.l_room = l_room;
	}

	public listRoom() {
		l_room = new ArrayList<>();
	}
	
	public void readFile() throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(FILE_room_type));
			String s = null;
			do {
				s = br.readLine();
				room_type room = new room_type();
				if(room.readFile(s)) 
					l_room.add(room);
			} while (s != null);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void docFile() throws IOException {
		BufferedReader nhap = null;
		try {
			nhap = new BufferedReader(new FileReader(FILE_room_type));
			String s = null;
			do {
				s = nhap.readLine();
				room_type u = new room_type();
				if (u.readFile(s))
					l_room.add(u);
			} while (s != null);
			nhap.close();
		} catch (Exception e) {
			System.out.println("Loi khi doc file " + FILE_room_type);
		}
	}
	 
	public void ghiDeFile() throws  IOException {
		List<room_type> tk = l_room;
		BufferedWriter fileOut = new BufferedWriter(new FileWriter(FILE_room_type)); 
			for (room_type a : tk) {
				a.writeFile(fileOut);
			}
	}

	 public void deleteAll(){
	        l_room.removeAll(l_room);
	    }
	 
	public void ghiFile() throws IOException {
		BufferedWriter xuat = new BufferedWriter(new FileWriter(FILE_room_type));
		for (room_type a : l_room)
			a.writeFile(xuat);
		xuat.close();
	}

	public void header() {
		System.out.println(" __________________________________________________________________________________________");
        //                       1            2           3       4           5             6               7       
        System.out.println("| Mã Phòng |  Loại Phòng  | Tầng | Sức chứa |   Mô tả   |        Giá        |  Trạng thái  |");
        System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
	}
	
	public void footer() {
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	public void xuatDanhSachPhong() {
			header();
	        for(room_type a : l_room) {
	        System.out.printf("|%-10d|%-14s|%-6d|%-10s|%-11s|%-19s|%-14s|\n"
	            ,a.getId()
	            ,a.getType()            
	            ,a.getFloor() 
	            ,a.getCapcity()
	            ,a.getDescription()  
	            ,a.getPrice()   
	            ,a.getStatus());
	        System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
	        }
		footer();
	}
	
	public void xuatDanhSachPhongTrong() {
		header();
		for(room_type a : l_room) {
			if(!a.getStatus().equals("Trống")) {
				continue;
			} else {
				System.out.printf("|%-10d|%-14s|%-6d|%-10s|%-11s|%-19s|%-14s|\n"
			            ,a.getId()
			            ,a.getType()            
			            ,a.getFloor() 
			            ,a.getCapcity()
			            ,a.getDescription()  
			            ,a.getPrice()   
			            ,a.getStatus());
			}
				
			System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
        }
		footer();
}

	public void xuatDanhSachPhongDat() {
		header();
		for(room_type a : l_room) {
			if(!a.getStatus().equals("Đã đặt")) {
				continue;
			} else {
				System.out.printf("|%-10d|%-14s|%-6d|%-10s|%-11s|%-19s|%-14s|\n"
			            ,a.getId()
			            ,a.getType()            
			            ,a.getFloor() 
			            ,a.getCapcity()
			            ,a.getDescription()  
			            ,a.getPrice()   
			            ,a.getStatus());
			}
				
			System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
        }
		footer();
}
	
	public boolean timPhongTheoMa (int id) {
		header();
		int k = 0;
		 for (Iterator<room_type> it = l_room.iterator(); it.hasNext();) {
	            room_type room = it.next();
	            if(!(room.getId() == id)){
	            	continue;
	            } else {
	            	System.out.printf("|%-10d|%-14s|%-6d|%-10s|%-11s|%-19s|%-14s|\n"
				            ,room.getId()
				            ,room.getType()            
				            ,room.getFloor() 
				            ,room.getCapcity()
				            ,room.getDescription()  
				            ,room.getPrice()   
				            ,room.getStatus());
	            	k++;
				}
					
				System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
	        }
		footer();
		if(k!=0) return true;
		return false;
	}
	
	public boolean timPhongTheoLoai (String type) {
		header();
		int k = 0;
		 for (Iterator<room_type> it = l_room.iterator(); it.hasNext();) {
	            room_type room = it.next();
	            if(!(StringUtils.removeAccent(room.getType()).compareToIgnoreCase(StringUtils.removeAccent(type)) == 0)){
	            	continue;
	            }  else {
	            	System.out.printf("|%-10d|%-14s|%-6d|%-10s|%-11s|%-19s|%-14s|\n"
				            ,room.getId()
				            ,room.getType()            
				            ,room.getFloor() 
				            ,room.getCapcity()
				            ,room.getDescription()  
				            ,room.getPrice()   
				            ,room.getStatus());
	            	k++;
	            }
				System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
	        }
		footer();
		if(k!=0) return true;
		return false;
	}
	
	public void timPhongTheoGiaDuoi500 () {
		header();
		 for (Iterator<room_type> it = l_room.iterator(); it.hasNext();) {
	            room_type room = it.next();
	            String a = room.getPrice().replace(".", "");
	            if(!(Integer.parseInt(a) <= 500000)){
	            	continue;
	            }  else {
	            	System.out.printf("|%-10d|%-14s|%-6d|%-10s|%-11s|%-19s|%-14s|\n"
				            ,room.getId()
				            ,room.getType()            
				            ,room.getFloor() 
				            ,room.getCapcity()
				            ,room.getDescription()  
				            ,room.getPrice()   
				            ,room.getStatus());
	            }
				System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
	        }
		footer();
	}
	
	public void timPhongTheoGiaTu500Den1tr () {
		header();
		 for (Iterator<room_type> it = l_room.iterator(); it.hasNext();) {
	            room_type room = it.next();
	            String a = room.getPrice().replace(".", "");
	            if(!(Integer.parseInt(a) > 500000 && Integer.parseInt(a) < 1000000 )){
	            	continue;
	            }  else {
	            	System.out.printf("|%-10d|%-14s|%-6d|%-10s|%-11s|%-19s|%-14s|\n"
				            ,room.getId()
				            ,room.getType()            
				            ,room.getFloor() 
				            ,room.getCapcity()
				            ,room.getDescription()  
				            ,room.getPrice()   
				            ,room.getStatus());
	            }
				System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
	        }
		footer();
	}

	public void timPhongTheoGiaTu1trDen2tr () {
		header();
		 for (Iterator<room_type> it = l_room.iterator(); it.hasNext();) {
	            room_type room = it.next();
	            String a = room.getPrice().replace(".", "");
	            if(!(Integer.parseInt(a) >= 1000000 && Integer.parseInt(a) <= 2000000 )){
	            	continue;
	            }  else {
	            	System.out.printf("|%-10d|%-14s|%-6d|%-10s|%-11s|%-19s|%-14s|\n"
				            ,room.getId()
				            ,room.getType()            
				            ,room.getFloor() 
				            ,room.getCapcity()
				            ,room.getDescription()  
				            ,room.getPrice()   
				            ,room.getStatus());
	            }
				System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
	        }
		footer();
	}
	
	public boolean timPhongTheoSucChua(int sucChua) {
		header();
		int k = 0;
		 for (Iterator<room_type> it = l_room.iterator(); it.hasNext();) {
	            room_type room = it.next();
	            String a[] = room.getCapcity().split("~");
	            	if(!(sucChua >= Integer.valueOf(a[0].trim()) && sucChua <= Integer.valueOf(a[1].trim()))){
	            		continue;
	            	} else {
	            		System.out.printf("|%-10d|%-14s|%-6d|%-10s|%-11s|%-19s|%-14s|\n"
					            ,room.getId()
					            ,room.getType()            
					            ,room.getFloor() 
					            ,room.getCapcity()
					            ,room.getDescription()  
					            ,room.getPrice()   
					            ,room.getStatus());
	            		k++;
	            	}
				System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
	        }
		footer();
		if(k!=0) return true;
		return false;
	}
	
	public String getPrice (int id) {
		 int k = 0;
			for(Iterator<room_type> it = l_room.iterator(); it.hasNext();) {
				room_type room = it.next();
				if(!(room.getId() == id)) {
					continue;
				} else {
					 k++;
				}
				if(k!=0) return room.getPrice();
			}
			return "Ko tìm thấy giá ";
	}
	
	public static void main(String[] args) throws IOException {
		listRoom lr = new listRoom();
		lr.readFile();
		lr.xuatDanhSachPhong();
		System.out.println(lr.getPrice(101)); 
	}
}
