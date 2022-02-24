package Les3;

public class Box <T extends Fruit> {
    T[] fruits;

    public Box(T[] fruits) {
        this.fruits = fruits;
    }

    public Float getWeight() {
        Float sum = 0x0.0p0f;
        for (T t : getFruits()) {
            if (t != null) {
                Float fr = t.getQuantity();
                sum = sum + fr;
            }
        }
        return sum;
    }
    public T[] getFruits() {
        return fruits;
    }

    public Boolean compare(Box<? extends Fruit> box) {
        if (this.getWeight().intValue() == box.getWeight().intValue()) {
            return true;
        } else {
            return false;
        }
    }

    public void process(Box<T> box) {
        System.out.println("Box1: " + this.getWeight());
        System.out.println("Box2: " + box.getWeight());
        for (int i = 0; i < box.getFruits().length; i++) {
            if (box.getFruits()[i] != null) {
                this.getFruits()[getSize()] = box.getFruits()[i];
                box.getFruits()[i] = null;
            }
        }
        System.out.println("Box1 after process: " + this.getWeight());
        System.out.println("box2 after process: " + box.getWeight());
    }
    private Integer getSize() {
        Integer sum = 0;
        for (T t : getFruits()) {
            if (t != null) sum++;
        }
        return sum;
    }
}