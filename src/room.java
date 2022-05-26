import java.util.Scanner;


public class room {
	private int id; // 101
	private int floor; // 1
	private String status;// het phong
	
	Scanner sc = new Scanner(System.in);

	public room() {
	}

	public room(int id, int floor, String status) {
		this.id = id;
		this.floor = floor;
		this.status = status;
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
		
	}
	
	public void xuat() {
		System.out.println("Ma phong: " + getId() + "Tang: " + getFloor() + "Trang thai: " + getStatus());
	}

}
