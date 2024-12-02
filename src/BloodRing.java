public class BloodRing implements Accessory {
    @Override
    public String getName() {
        return "Blood Ring";
    }

    @Override
    public double getBuffHp() {
        return 50;
    }

    @Override
    public double getBuffMana() {
        return 0;
    }

    @Override
    public double getBuffSpeed() {
        return 2;
    }
}
