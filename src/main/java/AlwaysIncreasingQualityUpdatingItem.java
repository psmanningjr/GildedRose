
public class AlwaysIncreasingQualityUpdatingItem extends UpdatingItem {

	public AlwaysIncreasingQualityUpdatingItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void update() {
		incrementQualityIfLessThanMaxQuality();
		decrementSellIn();
	}


}
