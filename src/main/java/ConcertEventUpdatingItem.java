
public class ConcertEventUpdatingItem extends UpdatingItem {

	public ConcertEventUpdatingItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public void update() {
		changedQualityBasedOnDaysAwayFromConcert();
		decrementSellIn();
		if (sellByDatePast()) {
			setQuality(0);
		}
	}
	
	public void changedQualityBasedOnDaysAwayFromConcert() {
		incrementQualityIfLessThanMaxQuality();
		if (getSellIn() < 11) {
			incrementQualityIfLessThanMaxQuality();
		}
		if (getSellIn() < 6) {
			incrementQualityIfLessThanMaxQuality();
		}
	}

}
