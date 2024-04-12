package org.example;

import java.util.Objects;

class Order implements Comparable {
    private String product;
    private double cost;

    public Order(String product, double cost) {
        this.product = product;
        this.cost = cost;
    }

    public String getProduct() {
        return product;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return product + ", " + "sum = " + cost ;
    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (this.product == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Order order = (Order) object;
        return Objects.equals(product, order.product);
    }

    @Override
    public int compareTo(Object o) {
        Order temp = (Order) o;
        if(this.cost > temp.getCost())
            return 1;
        else if(this.cost < temp.getCost())
            return -1;
        else
            return 0;
    }
}
