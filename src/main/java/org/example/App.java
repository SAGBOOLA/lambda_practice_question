package org.example;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Butter",145.00,20));
        products.add(new Product("Eggs",120.00,5));
        products.add(new Product("Cheese",250.00,15));
        products.add(new Product("Bread",140.00,0));
        products.add(new Product("IceCream",150.00,9));
        products.add(new Product("Milk",110.00,0));

        implement(products,zeroStockValue,result);
        System.out.println("-----------------------");
        implement(products,productsWithB,result);
        System.out.println("-----------------------");
        implement(products,productsPriceRange,result);
        System.out.println("-----------------------");
        implement(products,increaseProducts,result);
    }

    public static void implement(List<Product> products, Conditional filter, Action perform){
        for (Product product:products){
            if (filter.test(product)){
                perform.execute(product);
            }
        }
    }

    static Action result = System.out::println;
    static Conditional zeroStockValue = p->p.getStock()==0;
    static Conditional productsWithB = p->p.getProductName().startsWith("B");
    static Conditional productsPriceRange = p->p.getPrice()>100 && p.getPrice()<150;
    static Conditional increaseProducts = p->(p.getStock()<10 && p.getStock()>0);

}
