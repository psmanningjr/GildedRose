import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<UpdatingItem> items = null;
		System.out.println("OMGHAI!");

		items = new ArrayList<UpdatingItem>();
		items.add(UpdatingItemFactory.create("+5 Dexterity Vest", 10, 20));
		items.add(UpdatingItemFactory.create("Aged Brie", 2, 0));
		items.add(UpdatingItemFactory.create("Elixir of the Mongoose", 5, 7));
		items.add(UpdatingItemFactory.create("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(UpdatingItemFactory.create("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(UpdatingItemFactory.create("Conjured Mana Cake", 3, 6));

		updateQuality(items);
	}

	public static void updateQuality(List<UpdatingItem> updatingItems) {
		for (UpdatingItem item : updatingItems) {
			item.update();
		}
	}

}