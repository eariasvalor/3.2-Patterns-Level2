package observer.entities;

import observer.interfaces.Observable;
import observer.interfaces.Observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Broker implements Observable {
    private List<Observer> observers;
    private StockMarket stockMarket;

    public Broker(StockMarket stockMarket) {
        if (stockMarket == null) {
            throw new IllegalArgumentException("The stock market cannot be null.");
        }
        this.observers = new ArrayList<>();
        this.stockMarket = stockMarket;
    }

    public StockMarket getStockMarket() {
        return stockMarket;
    }

    public List<Observer> getObservers() {
        return Collections.unmodifiableList(observers);
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("The observer cannot be null.");
        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer == null) {
            throw new IllegalArgumentException("The observer cannot be null.");
        }
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockMarket);
        }
    }

    public void updateStockValue(float newValue) {
        if (newValue < 0f) {
            throw new IllegalArgumentException("Value cannot be negative.");
        }
        float oldValue = stockMarket.getCurrentValue();
        stockMarket.updateValue(newValue);

        if (newValue != oldValue) {
            System.out.println("Market changed! New value: " + newValue + " (" + stockMarket.getTrend() + ")");
            notifyObservers();
        } else {
            System.out.println("No change in the market value.");
        }
    }
}
