public class Singleton {
	public static void main(String[] args) {
		for (int i = 0; i < 9999; i++) {
			Renban renban = Renban.getInstance();
			System.out.println(renban.getNumber());
		}
	}
}

class Renban {
	private static Renban number = new Renban();
	private int num = 0;

	public static Renban getInstance() {
		return number;
	}

	public int getNumber() {
		num++;
		return num;
	}
}