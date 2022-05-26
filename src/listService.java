import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class listService {
	protected List<service> l_service;
	public static final String FILE_service = "./src/service.txt";
	Scanner scan = new Scanner(System.in);

	public listService(List<service> l_service) {
		this.l_service = l_service;
	}

	public listService() {
		l_service = new ArrayList<>();
	}

	public void docFile() throws IOException {
		BufferedReader nhap = null;
		try {
			nhap = new BufferedReader(new FileReader(FILE_service));
			String s = null;
			do {
				s = nhap.readLine();
				service u = new service();
				if (u.readFile(s))
					l_service.add(u);
			} while (s != null);
			nhap.close();
		} catch (Exception e) {
			System.out.println("Loi khi doc file " + FILE_service);
		}
	}

	public void ghiDeFile() throws  IOException {
		List<service> tk = l_service;
		BufferedWriter fileOut = new BufferedWriter(new FileWriter(FILE_service)); 
			for (service a : tk) {
				a.writeFile(fileOut);
			}
	}

	public void ghiFile() throws IOException {
		BufferedWriter xuat = new BufferedWriter(new FileWriter(FILE_service));
		for (service a : l_service)
			a.writeFile(xuat);
		xuat.close();
	}
	
	public void header() {
		System.out.println(" ________________________________________________");
        //                         1          2            					3           4            5           				 6           7                         9               10         11
        System.out.println("|   ID   |          TÊN DỊCH VỤ         |  GIÁ   |");
        System.out.println("|________|______________________________|________|");
	}
	public void foooter () {
		System.out.println("|________|______________________________|________|");

	}
	public void danhSachDichVu () {
		header();
		 for(service service : l_service) {
		        System.out.printf( 
		                    "|%-8d|%-30s|%-8s|\n"
		            , service.getMaDV(),
		            service.getServiceName(),
		            service.getservicePrice()
		        );
		        foooter();
		        }
	}
	
	public String getName(int id) {
		 int k = 0;
			for(Iterator<service> it = l_service.iterator(); it.hasNext();) {
				service service = it.next();
				if(!( service.getMaDV() == id)) {
					continue;
				} else {
					 k++;
				}
				if(k!=0) return service.getServiceName();
			}
			
			return "Chưa có";
		} 
	
	public String getPrice(int id) {
		 int k = 0;
			for(Iterator<service> it = l_service.iterator(); it.hasNext();) {
				service service = it.next();
				if(!( service.getMaDV() == id)) {
					continue;
				} else {
					 k++;
				}
				if(k!=0) return service.getservicePrice();
			}
			
			return "Ko tìm thấy ";
		} 
	
	public static void main(String[] args) throws IOException {
		listService service = new listService();
		service.docFile();
		System.out.println(service.getPrice(4)); 
	}
}
