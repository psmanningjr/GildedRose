import java.util.ArrayList;
import java.util.List;


public class GildedRose {
	final static String AGED_BRIE = "Aged Brie";
	final static String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";
	final static String SULFURAS = "Sulfuras, Hand of Ragnaros";

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
        for (int i = 0; i < items.size(); i++)
        {
            if (regularDecrementingQualityItem(items.get(i))) 
            {
                if (items.get(i).getQuality() > 0)
                {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                }
            }
            else
            {
                if (items.get(i).getQuality() < 50)
                {
                    items.get(i).setQuality(items.get(i).getQuality() + 1);

                    if (BACKSTAGE_PASS.equals(items.get(i).getName()))
                    {
                        if (items.get(i).getSellIn() < 11)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }

                        if (items.get(i).getSellIn() < 6)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!SULFURAS.equals(items.get(i).getName()))
            {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }

            if (items.get(i).getSellIn() < 0)
            {
                if (!AGED_BRIE.equals(items.get(i).getName()))
                {
                    if (!BACKSTAGE_PASS.equals(items.get(i).getName()))
                    {
                        if (items.get(i).getQuality() > 0)
                        {
                            if (!SULFURAS.equals(items.get(i).getName()))
                            {
                                items.get(i).setQuality(items.get(i).getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                }
                else
                {
                    if (items.get(i).getQuality() < 50)
                    {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
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