package observer.entities;

import observer.interfaces.Observer;

public class StockAgency implements Observer {
    private String name;

    public StockAgency(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public void update(StockMarket stockMarket) {
        System.out.println("[" + name + "] Market update received:");
        System.out.println(" - Market: " + stockMarket.getName());
        System.out.println(" - Current value: " + stockMarket.getCurrentValue() + " " + stockMarket.getCurrency());
        System.out.println(" - Trend: " + stockMarket.getTrend());
        System.out.println("-----------------------------------");
    }

}
