package 유정선2;

public class Transportation {
	int n;
	int ppl=0;
	int revenue=0;
	int price;
	public Transportation(int n, int price) {
		this.n = n;
		this.ppl = ppl;
		this.price = price;
	}
	public void giveRide(Student student) {
		if(student.getTransfer()>0 && student.getTransfer()<3) {
			if(student.pay(300)) {
				this.revenue+= 300;
				student.transferRide();
				this.ppl++;
			}
			else System.out.println("error");
		}
		else {
			student.setTransfer(0);
			if(student.pay(this.price)) {
				this.revenue+= this.price;
				student.transferRide();
				this.ppl++;
			}
			else System.out.println("error");
		}
		
	}
	public void print() {
		System.out.println(this.revenue);
	}

}
