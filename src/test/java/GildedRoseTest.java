import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class GildedRoseTest {
	
	List<Item> goods;
	
	private void createOneItemList(Item item) {
		goods = new ArrayList<Item>();
		goods.add(item);
	}

	@Test
	public void WithNormalItemSellInValueDecreaseByOneEachDay() {
		createOneItemList(new Item("Conjured Mana Cake", 3, 6));

		GildedRose.updateQuality(goods);
		
		assertEquals(2,goods.get(0).getSellIn());
	}

	@Test
	public void WithNormalItemQualityValueDecreaseByOneEachDay() {
		createOneItemList(new Item("Conjured Mana Cake", 3, 6));
		
		GildedRose.updateQuality(goods);
		
		assertEquals(5,goods.get(0).getQuality());
	}
	
	@Test
	public void WithNormalItemQualityValueDecreaseByTwoAfterSellInPasses() {
		createOneItemList(new Item("Conjured Mana Cake", 1, 6));

		GildedRose.updateQuality(goods);
		GildedRose.updateQuality(goods);
		assertEquals(3,goods.get(0).getQuality());	
	}
	
	@Test
	public void WithNormalItemQualityValueDoesNotGoNegative() {
		createOneItemList(new Item("Conjured Mana Cake", 1, 1));

		GildedRose.updateQuality(goods);
		assertEquals(0,goods.get(0).getQuality());	
		GildedRose.updateQuality(goods);
		assertEquals(0,goods.get(0).getQuality());	
	}
	
	@Test
	public void AgedBrieIncreaseInQualityByOneEachDay() {
		createOneItemList(new Item("Aged Brie", 2, 0));

		GildedRose.updateQuality(goods);
		assertEquals(1,goods.get(0).getQuality());
	}	
	
	@Test
	public void AgedBrieQualityDoesNotIncreasePastFifty() {
		createOneItemList(new Item("Aged Brie", 2, 49));

		GildedRose.updateQuality(goods);
		assertEquals(50,goods.get(0).getQuality());
		GildedRose.updateQuality(goods);
		assertEquals(50,goods.get(0).getQuality());
	}	
	
	@Test
	public void SulfurasDoesNotChangeQuality() {
		createOneItemList(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

		GildedRose.updateQuality(goods);
		assertEquals(80,goods.get(0).getQuality());
		GildedRose.updateQuality(goods);
		assertEquals(80,goods.get(0).getQuality());
	}	
	
	@Test
	public void SulfurasSellInDoesNotChange() {
		createOneItemList(new Item("Sulfuras, Hand of Ragnaros", 0, 80));

		GildedRose.updateQuality(goods);
		assertEquals(0,goods.get(0).getSellIn());
		GildedRose.updateQuality(goods);
		assertEquals(0,goods.get(0).getSellIn());
	}	
	
	@Test
	public void BackstagePassesQualityIncreaseByOneIfMoreConcertIsMoreThanTenDaysAway() {
		createOneItemList(new Item("Backstage passes to a TAFKAL80ETC concert", 12, 20));

		GildedRose.updateQuality(goods);
		assertEquals(21,goods.get(0).getQuality());
		GildedRose.updateQuality(goods);
		assertEquals(22,goods.get(0).getQuality());
		GildedRose.updateQuality(goods);
		assertTrue(goods.get(0).getQuality() > 23);
	}	
		
	@Test
	public void BackstagePassesQualityIncreaseByTwoIfConcertIsTenDaysAway() {
		createOneItemList(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));

		GildedRose.updateQuality(goods);
		assertEquals(22,goods.get(0).getQuality());
		GildedRose.updateQuality(goods);
		assertEquals(24,goods.get(0).getQuality());
	}	
	
	@Test
	public void BackstagePassesQualityIncreaseByOneIfConcertIsSixDaysAway() {
		createOneItemList(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20));

		GildedRose.updateQuality(goods);
		assertEquals(22,goods.get(0).getQuality());
	}	
	
	@Test
	public void BackstagePassesQualityIncreaseByThreeIfConcertIsFiveDaysAway() {
		createOneItemList(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));

		GildedRose.updateQuality(goods);
		assertEquals(23,goods.get(0).getQuality());
	}	

	@Test
	public void BackstagePassesQualityIncreaseByThreeIfConcertIsFourDaysAway() {
		createOneItemList(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 20));

		GildedRose.updateQuality(goods);
		assertEquals(23,goods.get(0).getQuality());
	}	

	@Test
	public void BackstagePassesQualityIsZeroAFterConcert() {
		createOneItemList(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));

		GildedRose.updateQuality(goods);
		assertEquals(0,goods.get(0).getQuality());
	}	
}
