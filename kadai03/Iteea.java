import java.util.ArrayList;
import java.util.List;

public class IteratorSample1 {
	public static void main(String[] args) {
		GameListAggregate gameListAggregate = new GameListAggregate();
		Iterator iterator = gameListAggregate.createIterator();
		gameListAggregate.add(new Game("ポケモン赤　", 6234));
		gameListAggregate.add(new Game("ポケモン金　", 5232));
		gameListAggregate.add(new Game("ポケモン青　", 8493));
		gameListAggregate.add(new Game("ポケモン銀　", 5432));
		iterator.first(); // まず探す場所を先頭位置にしてもらる
		while (!iterator.isDone()) { // まだある？ まだあるよ！
			Game game = (Game) iterator.getItem(); // はいどうぞ (と受取る)
			System.out.print(game.getName());
			System.out.println(game.getPrice());
			iterator.next(); // 次を頂戴
		}
	}
}

class Game {
	private String name; // 名称
	private int price; // 価格

	public Game(String name, int price) { // コンストラクタ
		this.name = name;
		this.price = price;
	}

	public String getName() { // 名称を取得
		return name;
	}

	public int getPrice() { // 価格を取得
		return price;
	}
}

class GameListAggregate {
	private List<Game> list = new ArrayList<>();
	private int numberOfStock;

	public Iterator createIterator() {
		return new GameListIterator(this);
	}

	public void add(Game game) {
		list.add(game);
		numberOfStock++;
	}

	public Game getAt(int number) {
		return list.get(number);
	}

	public int getNumberOfStock() {
		return numberOfStock;
	}
}

interface Aggregate {
	public Iterator createIterator();
}

class GameListIterator implements Iterator {
	private GameListAggregate aggregate;
	private int current;

	public GameListIterator(GameListAggregate aggregate) {
		this.aggregate = aggregate;
	}

	@Override
	public void first() {
		current = 0;
	}

	@Override

	public void next() {
		current += 1;
	}

	@Override
	public boolean isDone() {
		if (current >= aggregate.getNumberOfStock()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Game getItem() {
		return aggregate.getAt(current);
	}
}

interface Iterator {
	public void first(); // 取り出し位置を最初の要素へ変える

	public void next(); // 取り出し位置を次の要素へ変える

	public boolean isDone(); // 取り出し位置が最後を超えたか？

	public Game getItem(); // 現在の取り出し位置から取り出す
}