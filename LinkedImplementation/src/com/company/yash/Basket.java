package com.company.yash;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        list= new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if ((item != null) && quantity > 0){
            int items = list.getOrDefault(item, 0 );
            list.put(item, items + quantity);
            return items;
        }
        return 0;
    }

    public Map<StockItem, Integer> items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
       StringBuilder s = new StringBuilder("\nShopping Basket " + name + " Contains " + list.size() + " items\n");
       double totalCost = 0.0;
       for (Map.Entry<StockItem, Integer> item : list.entrySet()){
           s.append(item.getKey()).append(".").append(item.getValue()).append(" purchased.\n");
           totalCost += item.getKey().getPrice() * item.getValue();
       }
       return s.append("Total cost: ").append(totalCost).toString();
    }
}
