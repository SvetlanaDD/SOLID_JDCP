package ru.netology;

import java.util.Map;

public class Basket {

    protected int count;
    protected Purchase[] purchases;

    public Basket(int productsCount) {
        this.count = productsCount;
        this.purchases = new Purchase[count];
    }

    public void addPurchase(Purchase purchase) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(purchase.title, purchase.count);
                return;
            }
            if (purchases[i].title.equals(purchase.title)) {
                purchases[i].count += purchase.count;
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (Purchase purchase : purchases) {
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += (long) purchase.count * prices.get(purchase.title);
        }
        return sum;
    }
}
