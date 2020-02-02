public class Client {
	public static void main(String[] args) {
		Dengen d;

		d = new AcAdapter();
		int denatsu = d.kyuuden();
		System.out.println(denatsu + "V で給電されています");
	}
}

abstract class Dengen { // Target
	abstract int kyuuden();
}

class Adaptee { // Adaptee
	public int power() {
		return 100;
	}
}

class AcAdapter extends Dengen { // Adapter

	Adaptee adaptee;

	public AcAdapter() {
		this.adaptee = new Adaptee();
	}

	public int kyuuden() {
		return (int) (adaptee.power() * 0.16);
	}
}