
public class DoubleSpeedDegradingUpdatingItem extends UpdatingItem {

	public DoubleSpeedDegradingUpdatingItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}
	
	public void update() {
		decrementQualityIfGreaterThanZero();
		decrementQualityIfGreaterThanZero();
		decrementSellIn();
		if (sellByDatePast()) {
			decrementQualityIfGreaterThanZero();
		}

	}

}
