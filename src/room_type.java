import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;


public class room_type {
	private int id; // 101
	private int floor; // 1
	private String status;// het phong
	private String type; // vip or normal
	private String capcity; //suc chua
	private String description; // phong nhu cc
	private String price; // 100/1h

	Scanner sc = new Scanner(System.in);
	String pattern = "###,###.###";
	DecimalFormat decimalFormat = new DecimalFormat(pattern);

	public room_type() {
	}

	public room_type(int id, int floor, String status ,String type, String capcity, String description, String price) {
//		this(id, floor, status);
		this.type = type;
		this.capcity = capcity;
		this.description = description;
		this.price = price;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCapcity() {
		return capcity;
	}

	public void setCapcity(String capcity) {
		this.capcity = capcity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status.equals(String.valueOf(0))) {
			this.status = "Trống";
		} else
			this.status = "Đã đặt";
}
	public void setInfo() {
		System.out.println("Nhập mã phòng: ");
		setId(Integer.parseInt(sc.nextLine()));
		setFloor(0);
		setStatus("");
		System.out.println("Nhập loại phòng: ");
		setType(sc.nextLine());
		System.out.println("Nhập sức chứa: ");
		setCapcity(sc.nextLine());
		System.out.println("Nhap mo ta: ");
		setDescription(sc.nextLine());
		System.out.println("Nhap gia phong:");
//		String format = decimalFormat.format(sc.nextDouble());
//		System.out.println(format);    
		setPrice(sc.nextLine());
	}
	
	 public void display(){
	        System.out.println(" __________________________________________________________________________________________");
	        //                       1            2           3       4           5             6               7       
	        System.out.println("| Mã Phòng |  Loại Phòng  | Tầng | Sức chứa |   Mô tả   |        Giá        |  Trạng thái  |");
	        System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
	        System.out.printf( 
	        			//   1     2    3     4    5    6     7   
	                    "|%-10d|%-14s|%-6d|%-10s|%-11s|%-19s|%-14s|\n"
	            ,this.getId()
	            ,this.getType()            
	            ,this.getFloor() 
	            ,this.getCapcity()
	            ,this.getDescription()  
	            ,this.getPrice()   
	            ,this.getStatus()
	        );
	        System.out.println("|__________|______________|______|__________|___________|___________________|______________|");
	        System.out.println("");
	    }
	    
	
	public void xuat() {
		System.out.println("Loai phong: " + getType() + 
				"Suc chua: " + getCapcity() + 
				"Mo ta: " + getCapcity() +
				"Gia: " + getPrice());
	}
	
	public void writeFile(BufferedWriter out) throws IOException{
        try {
            // khi viet file viet them dau | vao giua
            out.write(this.getId() + "|");
            out.write(this.getType() + "|");
            out.write(this.getFloor() + "|");
            out.write(this.getCapcity()+ "|");
            out.write(this.getDescription() + "|");
            out.write(this.getPrice() + "|");
            out.write(this.getStatus() + "|");
            out.newLine();
        } catch (Exception e) {
            System.out.println("Lỗi khi ghi gile");
        }
    }
    
    public boolean readFile(String s){ 
        if (s!=null){
            // khi doc file doc toi dau |
            String[] inp = s.split("\\|");
            this.setId(Integer.parseInt(inp[0]));
            this.setType(inp[1]);
            this.setFloor(Integer.parseInt(inp[2]));
            this.setCapcity(inp[3]);
            this.setDescription(inp[4]);
            this.setPrice(inp[5]);
            this.setStatus(inp[6]);
            return true;
        }
        return false;
    }
    
	
}
