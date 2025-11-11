package observer;

import observer.entities.Broker;
import observer.entities.StockAgency;
import observer.entities.StockMarket;

public class Main {
    public static void main(String[] args){
        StockMarket ibex = new StockMarket("IBEX 35", 9500.0f, "EUR");
        Broker broker = new Broker(ibex);
        StockAgency agency1 = new StockAgency("Alpha Investments");
        StockAgency agency2 = new StockAgency("Beta Capital");
        StockAgency agency3 = new StockAgency("Omega Securities");

        broker.addObserver(agency1);
        broker.addObserver(agency2);
        broker.addObserver(agency3);

        System.out.println("Current observers: ");
        broker.getObservers().forEach(o -> System.out.println(((StockAgency) o).getName()));
        System.out.println("-----------------------------------\n");

        broker.updateStockValue(9600.0f);
        broker.updateStockValue(9400.0f);
        broker.updateStockValue(9400.0f);
        broker.updateStockValue(9550.0f);

        broker.removeObserver(agency2);
        System.out.println("\nAfter removing Beta Capital:");
        broker.updateStockValue(9700.0f);
    }
}
