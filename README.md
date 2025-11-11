# Observer Pattern – Stock Market (Level 2)

## Description
This project implements the **Observer** design pattern in Java.  
A **Broker** (*Observable*) notifies multiple **Stock Agencies** (*Observers*) whenever the **Stock Market** value **goes up or down**.

> Requirement satisfied: the Observable object (`Broker`) **keeps references** to all registered Observers and notifies them on changes.

---

## Packages & Structure

```
src/
 └── main/
     └── java/
         └── observer/
             ├── Main.java
             ├── interfaces/
             │   ├── Observable.java
             │   └── Observer.java
             └── entities/
                 ├── Broker.java        // Observable (subject)
                 ├── StockAgency.java   // Observer (concrete observer)
                 └── StockMarket.java   // Market data model
```

**Packages**
- `observer.interfaces` → Pattern contracts.
- `observer.entities` → Concrete implementations and domain model.
- `observer` → `Main` entry point.

---

## Class Overview

### `observer.interfaces.Observable`
Contract for subjects:
- `void addObserver(Observer o)`
- `void removeObserver(Observer o)`
- `void notifyObservers()`

### `observer.interfaces.Observer`
Contract for observers:
- `void update(StockMarket stockMarket)`

### `observer.entities.StockMarket`
Domain model holding market state:
- `name`, `currentValue`, `previousValue`, `trend` (`"UP" | "DOWN" | "STABLE"`), `currency`
- `void updateValue(float newValue)` recalculates trend.

### `observer.entities.Broker` (Observable)
Keeps a list of observers and a `StockMarket` instance.  
Notifies observers when the market value **actually changes**.

### `observer.entities.StockAgency` (Observer)
Receives updates and prints the new market state. Includes **null checks** and a **non-blank name** validation.

---

## How It Works

1. Create a `StockMarket` instance (e.g., **IBEX 35**).
2. Create a `Broker` with that market.
3. Create one or more `StockAgency` observers and register them in the broker.
4. Call `broker.updateStockValue(newValue)` to simulate market changes.  
   When the value changes, the broker **notifies all observers**, passing the `StockMarket` object.

---

## Quick Start

### Requirements
- Java 17+
- Gradle

### Build & Run
```bash
# From project root
gradle build

# Run from IDE by executing observer.Main
# or if you have an application plugin configured, gradle run
```

### Example (Main)
```java
package observer;

import observer.entities.Broker;
import observer.entities.StockAgency;
import observer.entities.StockMarket;

public class Main {
    public static void main(String[] args) {
        StockMarket ibex = new StockMarket("IBEX 35", 9500.0f, "EUR");
        Broker broker = new Broker(ibex);

        StockAgency alpha = new StockAgency("Alpha Investments");
        StockAgency beta  = new StockAgency("Beta Capital");

        broker.addObserver(alpha);
        broker.addObserver(beta);

        broker.updateStockValue(9600.0f); // UP -> notifies
        broker.updateStockValue(9400.0f); // DOWN -> notifies
        broker.updateStockValue(9400.0f); // no change -> no notification
    }
}
```
