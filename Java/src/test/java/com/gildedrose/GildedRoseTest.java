package com.gildedrose;

import org.approvaltests.Approvals;
import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        CombinationApprovals.verifyAllCombinations(this::doUpdate,
            new String[]{"foo","Aged Brie","Backstage passes to a TAFKAL80ETC concert","Sulfuras, Hand of Ragnaros"},
            new Integer[]{0,-1,3,17,20,50},
            new Integer[]{0,-1,1,10,30,48,49,60,100});
    }

    private String doUpdate(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }
}
