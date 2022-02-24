package Les3;

public abstract class Fruit {
    private String name;
    private float quantity;

    public Fruit(String name, float quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public float getQuantity() {
        return quantity;
    }
}
class Apples extends Fruit{

    public Apples(float quantity) {
        super("Apple", quantity);
    }
}
class Oranges extends Fruit{

    public Oranges(float quantity) {
        super("Orange", quantity);
    }
}