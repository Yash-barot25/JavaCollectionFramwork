package com.company.yash;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {

            StockItem stockItem = list.getOrDefault(item.getName(), item);
            if (stockItem != item) {
                item.adjustStock(stockItem.getQuantityInStock());
            }
            list.put(item.getName(), item);
            return item.getQuantityInStock();
        }
        return 0;
    }

    public int sellStock(String name, int quantity) {
        StockItem item = list.getOrDefault(name, null);
        if ((item != null) && (item.getQuantityInStock() >= quantity) && (quantity > 0)) {
            item.adjustStock(-quantity);
            return item.getQuantityInStock();
        }
        return 0;
    }

    public StockItem getStockItem(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.getQuantityInStock();
            s = s + stockItem + " There are " + stockItem.getQuantityInStock() + " in stock. " + "Value of ";
             s = s + (stockItem.getQuantityInStock() > 1 ? "Items " : "Item ") + "$" + String.format("%02.2f",itemValue) + "\n";
             totalCost += itemValue;
        }
        return s + "\nTotal value of items $" + String.format("%.2f", totalCost);
    }
}
