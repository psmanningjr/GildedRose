import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class GildedRoseTest {
	
	List<UpdatingItem> goods;
	
	private void createOneItemList(String name, int sellIn, int quality) {
		goods = new ArrayList<UpdatingItem>();
		goods.add(UpdatingItemFactory.create(name, sellIn, quality));
	}

	@Test
	public void WithNormalItemSellInValueDecreaseByOneEachDay() {
		createOneItemList("Elixir of the Mongoose", 3, 6);

		GildedRose.updateQuality(goods);
		
		assertEquals(2,goods.get(0).getSellIn());
	}

	@Test
	public void WithNormalItemQualityValueDecreaseByOneEachDay() {
		createOneItemList("Elixir of the Mongoose", 3, 6);
		
		GildedRose.updateQuality(goods);
		
		assertEquals(5,goods.get(0).getQuality());
	}
	
	@Test
	public void WithNormalItemQualityValueDecreaseByTwoAfterSellInPasses() {
		createOneItemList("Elixir of the Mongoose", 1, 6);

		GildedRose.updateQuality(goods);
		GildedRose.updateQuality(goods);
		assertEquals(3,goods.get(0).getQuality());	
	}
	
	@Test
	public void WithNormalItemQualityValueDoesNotGoNegative() {
		createOneItemList("Elixir of the Mongoose", 1, 1);

		GildedRose.updateQuality(goods);
		assertEquals(0,goods.get(0).getQuality());	
		GildedRose.updateQuality(goods);
		assertEquals(0,goods.get(0).getQuality());	
	}
	
	@Test
	public void AgedBrieIncreaseInQualityByOneEachDay() {
		createOneItemList("Aged Brie", 2, 0);

		GildedRose.updateQuality(goods);
		assertEquals(1,goods.get(0).getQuality());
	}	
	
	
	@Test
	public void AgedBrieIncreaseInQualityEvenAfterSellIn() {
		createOneItemList("Aged Brie", 0, 10);

		GildedRose.updateQuality(goods);
		assertEquals(11,goods.get(0).getQuality());
	}	
	
	@Test
	public void AgedBrieQualityDoesNotIncreasePastFifty() {
		createOneItemList("Aged Brie", 2, 49);

		GildedRose.updateQuality(goods);
		assertEquals(50,goods.get(0).getQuality());
		GildedRose.updateQuality(goods);
		assertEquals(50,goods.get(0).getQuality());
	}	
	
	@Test
	public void SulfurasDoesNotChangeQuality() {
		createOneItemList("Sulfuras, Hand of Ragnaros", 0, 80);

		GildedRose.updateQuality(goods);
		assertEquals(80,goods.get(0).getQuality());
		GildedRose.updateQuality(goods);
		assertEquals(80,goods.get(0).getQuality());
	}	
	
	@Test
	public void SulfurasSellInDoesNotChange() {
		createOneItemList("Sulfuras, Hand of Ragnaros", 0, 80);

		GildedRose.updateQuality(goods);
		assertEquals(0,goods.get(0).getSellIn());
		GildedRose.updateQuality(goods);
		assertEquals(0,goods.get(0).getSellIn());
	}	
	
	@Test
	public void BackstagePassesQualityIncreaseByOneIfMoreConcertIsMoreThanTenDaysAway() {
		createOneItemList("Backstage passes to a TAFKAL80ETC concert", 12, 20);

		GildedRose.updateQuality(goods);
		assertEquals(21,goods.get(0).getQuality());
		GildedRose.updateQuality(goods);
		assertEquals(22,goods.get(0).getQuality());
		GildedRose.updateQuality(goods);
		assertTrue(goods.get(0).getQuality() > 23);
	}	
		
	@Test
	public void BackstagePassesQualityIncreaseByTwoIfConcertIsTenDaysAway() {
		createOneItemList("Backstage passes to a TAFKAL80ETC concert", 10, 20);

		GildedRose.updateQuality(goods);
		assertEquals(22,goods.get(0).getQuality());
		GildedRose.updateQuality(goods);
		assertEquals(24,goods.get(0).getQuality());
	}	
	
	@Test
	public void BackstagePassesQualityIncreaseByOneIfConcertIsSixDaysAway() {
		createOneItemList("Backstage passes to a TAFKAL80ETC concert", 6, 20);

		GildedRose.updateQuality(goods);
		assertEquals(22,goods.get(0).getQuality());
	}	
	
	@Test
	public void BackstagePassesQualityIncreaseByThreeIfConcertIsFiveDaysAway() {
		createOneItemList("Backstage passes to a TAFKAL80ETC concert", 5, 20);

		GildedRose.updateQuality(goods);
		assertEquals(23,goods.get(0).getQuality());
	}	

	@Test
	public void BackstagePassesQualityIncreaseByThreeIfConcertIsFourDaysAway() {
		createOneItemList("Backstage passes to a TAFKAL80ETC concert", 4, 20);

		GildedRose.updateQuality(goods);
		assertEquals(23,goods.get(0).getQuality());
	}	

	@Test
	public void BackstagePassesQualityIsZeroAFterConcert() {
		createOneItemList("Backstage passes to a TAFKAL80ETC concert", 0, 20);

		GildedRose.updateQuality(goods);
		assertEquals(0,goods.get(0).getQuality());
	}	

	@Test
	public void BackstagePassesWithDifferentNameQualityIsZeroAFterConcert() {
		createOneItemList("Backstage passes to a xyz concert", 0, 20);

		GildedRose.updateQuality(goods);
		assertEquals(0,goods.get(0).getQuality());
	}	

	//@Test
	public void ConjuredItemQualityDecreasesByTwoEachDay() {
		createOneItemList("Conjured Mana Cake", 3, 6);

		GildedRose.updateQuality(goods);
		assertEquals(4,goods.get(0).getQuality());
	}	

	//@Test
	public void ConjuredItemWithDifferentNameQualityDecreasesByTwoEachDay() {
		createOneItemList("Conjured Stuff", 3, 6);

		GildedRose.updateQuality(goods);
		assertEquals(4,goods.get(0).getQuality());
	}	
}
