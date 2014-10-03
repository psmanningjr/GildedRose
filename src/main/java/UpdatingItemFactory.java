public class UpdatingItemFactory {
	public enum ItemTypes {
		neverUpdating, alwaysIncreasingQuality, concertEvent, regular
	};

	final static String AGED_BRIE = "Aged Brie";
	final static String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
	final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
	final static String[] SPECIAL_ITEM_NAMES = { SULFURAS, AGED_BRIE,
			BACKSTAGE_PASS };
	final static ItemTypes[] SPECIAL_ITEM_TYPES = { ItemTypes.neverUpdating,
			ItemTypes.alwaysIncreasingQuality, ItemTypes.concertEvent };

	static UpdatingItem create(String name, int sellIn, int quality) {
		UpdatingItem updatingItem;
		ItemTypes itemType = typeOfItem(name);
		switch (itemType) {
		case neverUpdating:
			updatingItem = new NeverUpdatingItem(name, sellIn, quality);
			break;
		case alwaysIncreasingQuality:
			updatingItem = new AlwaysIncreasingQualityUpdatingItem(name,
					sellIn, quality);
			break;
		case concertEvent:
			updatingItem = new ConcertEventUpdatingItem(name, sellIn, quality);
			break;
		case regular:
		default:
			updatingItem = new UpdatingItem(name, sellIn, quality);
			break;
		}
		return updatingItem;
	}

	static ItemTypes typeOfItem(String name) {
		int foundAtIndex = -1;
		int index = 0;
		while (foundAtIndex < 0  && (index < SPECIAL_ITEM_NAMES.length)) {
			if (name.indexOf(SPECIAL_ITEM_NAMES[index]) == 0) {
				foundAtIndex = index;
			}
			index++;
		}
		return (foundAtIndex >-1) ? SPECIAL_ITEM_TYPES[foundAtIndex] : ItemTypes.regular;
	}
}
