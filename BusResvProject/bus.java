package BusResvProject;

public class bus {
	 int busNo;
	 int capacity;
	 boolean Ac;
	
	bus(int b,int c,boolean i){
		this.busNo=b;
		this.capacity=c;
		this.Ac=i;
	}
	void setBusNo(int bno) {
		this.busNo=bno;
	}
	
	int getBusNo() {
		return this.busNo;
	}
	
	void setcapacity(int capacity) {
		this.capacity=capacity;
	}
	
	int getcapacity() {
		return this.capacity;
	}
	
	void setBusAc(boolean bac) {
		this.Ac=bac;
	}
	
	boolean getBusAc(){
		return this.Ac;
	}
	
    void displayBusInfo()
    {
    	System.out.println("Bus Number : "+ busNo + " Bus capacity : " + capacity + " Ac : "+ Ac);
    }
}
