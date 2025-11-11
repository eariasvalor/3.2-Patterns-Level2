package observer.interfaces;

import observer.entities.StockMarket;

public interface Observer {
    void update(StockMarket stockMarket);
}
