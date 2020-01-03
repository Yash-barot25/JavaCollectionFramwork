package com.company.yash;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem item = new StockItem("Bread", 1.25, 25);
        stockList.addStock(item);

        item = new StockItem("chess", 0.1, 12);
        stockList.addStock(item);

        item = new StockItem("umbrella", 12.30, 3);
        stockList.addStock(item);

        item = new StockItem("gums", 1.05, 41);
        stockList.addStock(item);

        item = new StockItem("eggs", 2.35, 51);
        stockList.addStock(item);

        System.out.println(stockList);

        System.out.println("items of StockList");
        for (String s : stockList.items().keySet()) {
            System.out.println(s);
        }

        Basket basket = new Basket("Yash");
        sellItem(basket, "eggs", 15);
        System.out.println(basket);

        sellItem(basket, "gums", 8);
        sellItem(basket, "ak", 85);
        sellItem(basket, "gums", 8);
        System.out.println(basket);
//try {
        //Unsupported exception
        // stockList.items().put("abc", item);
//}catch (UnsupportedOperationException e){
//    System.out.println("You can't do that ");
//    e.printStackTrace();
//}
        stockList.items().get("gums").setQuantityInStock(2000000);
        System.out.println(stockList);
        stockList.getStockItem("gums").setQuantityInStock(-10000);
        System.out.println(stockList);
    }

    private static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.getStockItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }
}
