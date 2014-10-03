import java.util.ArrayList;
import java.util.List;

public class GildedRose {
	final static String AGED_BRIE = "Aged Brie";
	final static String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
	final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
	final static Integer MAX_QUALITY = 50;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<UpdatingItem> items = null;
		System.out.println("OMGHAI!");

		items = new ArrayList<UpdatingItem>();
		items.add(UpdatingItemFactory.createUpdatingItem("+5 Dexterity Vest", 10, 20));
		items.add(UpdatingItemFactory.createUpdatingItem("Aged Brie", 2, 0));
		items.add(UpdatingItemFactory.createUpdatingItem("Elixir of the Mongoose", 5, 7));
		items.add(UpdatingItemFactory.createUpdatingItem("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(UpdatingItemFactory.createUpdatingItem("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(UpdatingItemFactory.createUpdatingItem("Conjured Mana Cake", 3, 6));

		updateQuality(items);
	}

	public static void updateQuality(List<UpdatingItem> updatingItems) {
		for (UpdatingItem item : updatingItems) {
			item.update();
		}
	}

}