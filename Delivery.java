public class Delivery {
	public static void main(String[] args) {
		Finch f = new Finch();
		
		boolean move = false;
		while (true) {
			System.out.println(f.getButton("A"));
			if (move) {
				followLine(f);
			} else {
				f.stop();
			} 
			
			if (f.getButton("A") || f.getButton("B")) {
				move = !move;
			}
			f.pause(.1);
		}
	}
	
	public static void followLine(Finch f) {
		int left = f.getLine("L");
		int right = f.getLine("R");
		
		System.out.println("left: " + left + " right: " + right);
		if (left < 90) {
			f.setMotors(0, 10);
		} else if (right > 90) {
			f.setMotors(10, 0);
		} else {
			f.setMotors(10, 10);
		}
		f.pause(.1);
	}
}
