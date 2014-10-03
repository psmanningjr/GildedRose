public class UpdatingItem extends Item {
	final static Integer MAX_QUALITY = 50;

	public UpdatingItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void update() {
		decrementQualityIfGreaterThanZero();
		decrementSellIn();
		if (sellByDatePast()) {
			decrementQualityIfGreaterThanZero();
		}
	}

	public void decrementQualityIfGreaterThanZero() {
		if (getQuality() > 0) {
			setQuality(getQuality() - 1);
		}
	}

	public void incrementQualityIfLessThanMaxQuality() {
		if (getQuality() < MAX_QUALITY) {
			setQuality(getQuality() + 1);
		}
	}


	public void decrementSellIn() {
		setSellIn(getSellIn() - 1);
	}

	public boolean sellByDatePast() {
		return (getSellIn() < 0);
	}

}
