import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class GildedRoseTest {

	@Test
	public void testSellInValueDecreaseEachDayForNormalItem() {
		List<Item> goods = new ArrayList<Item>();
		goods.add(new Item("Conjured Mana Cake", 3, 6));
		GildedRose.updateQuality(goods);
		assertEquals(2,goods.get(0).getSellIn());
	}

	@Test
	public void testQualityValueDecreaseEachDayForNormalItem() {
		List<Item> goods = new ArrayList<Item>();
		goods.add(new Item("Conjured Mana Cake", 3, 6));
		GildedRose.updateQuality(goods);
		assertEquals(5,goods.get(0).getQuality());
	}
}
