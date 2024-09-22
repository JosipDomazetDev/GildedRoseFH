package com.gildedrose;


public class NormalItemStrategy implements ItemStrategy {
    @Override
    public void update(Item item) {
        decreaseQuality(item);
        item.sellIn--;

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }


}
