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
		
		List<Item> items = null;
        System.out.println("OMGHAI!");
		
        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality(items);
}


	
    public static void updateQuality(List<Item> items)
    {
        for (Item item : items)
        {
            if (regularDecrementingQualityItem(item)) 
            {
                if (item.getQuality() > 0)
                {
                        item.setQuality(item.getQuality() - 1);
                }
            }
            else
            {
                if (item.getQuality() < 50)
                {
                    item.setQuality(item.getQuality() + 1);

                    if (BACKSTAGE_PASS.equals(item.getName()))
                    {
                        if (item.getSellIn() < 11)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }

                        if (item.getSellIn() < 6)
                        {
                            if (item.getQuality() < 50)
                            {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!SULFURAS.equals(item.getName()))
            {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0)
            {
                if (!AGED_BRIE.equals(item.getName()))
                {
                    if (!BACKSTAGE_PASS.equals(item.getName()))
                    {
                        if (item.getQuality() > 0)
                        {
                            if (!SULFURAS.equals(item.getName()))
                            {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                }
                else
                {
                    if (item.getQuality() < MAX_QUALITY)
                    {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }



	private static boolean regularDecrementingQualityItem(Item item) {
		return (!AGED_BRIE.equals(item.getName()) && 
				!BACKSTAGE_PASS.equals(item.getName()) &&
				!SULFURAS.equals(item.getName()));
	}

}