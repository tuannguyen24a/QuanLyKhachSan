import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class service  {
	int maDV;
	String serviceName;
	String servicePrice;

	Scanner sc = new Scanner(System.in);
	
	public service() {
	}

	public service(int maDV, String serviceName, String servicePrice) {
		this.maDV = maDV;
		this.serviceName = serviceName;
		this.servicePrice = servicePrice;
	}


	public int getMaDV() {
		return maDV;
	}

	public void setMaDV(int maDV) {
		this.maDV = maDV;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getservicePrice() {
		return servicePrice;
	}

	public void setservicePrice(String servicePrice) {
		this.servicePrice = servicePrice;
	}
	
	public void nhap() {
		System.out.println("Nhập mã dịch vụ: ");
		setMaDV(Integer.parseInt(sc.nextLine()));
		System.out.println("Nhập tên dịch vụ: ");
		setServiceName(sc.nextLine());
		System.out.println("Nhập giá: ");
		setservicePrice(sc.nextLine());
	}
	
	 public void display(){
	        System.out.println(" __________________________________");
	        //                       1            2           3       4           5             6               7       
	        System.out.println("|Mã dịch vụ|  Tên dịch vụ |   Giá  |");
	        System.out.println("|__________|______________|________|");
	        System.out.printf( 
	        			//   1     2    3     4    5    6     7   
	                    "|%-10d|%-14s|%-8s|\n"
	            ,this.getMaDV()
	            ,this.getServiceName()            
	            ,this.getservicePrice()   
	        );
	        System.out.println("|__________|______________|________|");
	        System.out.println("");
	    }
	 public void writeFile(BufferedWriter out) throws IOException{
	        try {
	            // khi viet file viet them dau | vao giua
	            out.write(this.getMaDV() + "|");
	            out.write(this.getServiceName() + "|");
	            out.write(this.getservicePrice() + "|");
	            out.newLine();
	        } catch (Exception e) {
	            System.out.println("Lỗi khi ghi gile");
	        }
	    }
	    
	    public boolean readFile(String s){ 
	        if (s!=null){
	            // khi doc file doc toi dau |
	            String[] inp = s.split("\\|");
	            this.setMaDV(Integer.parseInt(inp[0]));
	            this.setServiceName(inp[1]);
	            this.setservicePrice(inp[2]);
	            return true;
	        }
	        return false;
	    }
}
