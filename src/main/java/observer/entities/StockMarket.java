package observer.entities;

public class StockMarket {
    private String name;
    private float currentValue;
    private float previousValue;
    private String trend;
    private String currency;

    public StockMarket(String name, float initialValue, String currency) {
        this.name = name;
        this.currentValue = initialValue;
        this.previousValue = initialValue;
        this.trend = "STABLE";
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public float getCurrentValue() {
        return currentValue;
    }

    public float getPreviousValue() {
        return previousValue;
    }

    public String getTrend() {
        return trend;
    }

    public String getCurrency() {
        return currency;
    }

    public void updateValue(float newValue){
        this.previousValue = this.currentValue;
        this.currentValue = newValue;

        if(newValue > previousValue){
            this.trend = "UP";
        } else if (newValue > previousValue){
            this.trend = "DOWN";
        } else {
            this.trend = "STABLE";
        }
    }

    @Override
    public String toString() {
        return "StockMarket{" +
                "name='" + name + '\'' +
                ", currentValue=" + currentValue +
                ", previousValue=" + previousValue +
                ", trend='" + trend + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
