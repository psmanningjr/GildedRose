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
	
}
