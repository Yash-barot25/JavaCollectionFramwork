package com.company.yash;

public class StockItem implements Comparable<StockItem>{

    private final String name;
    private double price;
    private int quantityInStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityInStock = 0;
    }

    public StockItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public void adjustStock(int quantity){

        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0 ){
            this.quantityInStock = newQuantity;
        }

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public int compareTo(StockItem o) {
        if (this == o){
            return 0;
        }

        if (o != null){
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException("from CompareTo()");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        String name = ((StockItem)o).getName();
        return this.name.equals(name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 44;
    }

    @Override
    public String toString() {
        return this.name + " price: " + this.price;
    }
}
