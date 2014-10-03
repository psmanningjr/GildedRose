
public class NeverUpdatingItem extends UpdatingItem {

	public NeverUpdatingItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void update() {}

}
