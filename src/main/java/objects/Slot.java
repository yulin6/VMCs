package objects;

import observer.SlotObservable;

public class Slot extends SlotObservable {

    private int id;
    private Drink drink;
    private int quantity;


    public Slot(int id, Drink drink, int quantity) {
        this.id = id;
        this.drink = drink;
        this.quantity = quantity;
    }

    public Boolean isAvailable() {
        return quantity == 0;
    }

    public int getId() {
        return id;
    }

    public Drink getDrink() {
        return this.drink;
    }

    public String getName() {
        return drink.getName();
    }

    public void setName(String name) {
        drink.setName(name);
        setSlotChanged();
        notifySlotObservers(SlotObserverType.NAME);
    }

    public int getPrice() { return drink.getPrice(); }

    public void setPrice(int price) {
        drink.setPrice(price);
        setSlotChanged();
        notifySlotObservers(SlotObserverType.PRICE);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        setSlotChanged();
        notifySlotObservers(SlotObserverType.QUANTITY);
    }
}
