public class WindBracelet implements Accessory {
    @Override
    public String getName() {
        return "Wind Bracelet";
    }

    @Override
    public double getBuffHp() {
        return 5;
    }

    @Override
    public double getBuffMana() {
        return 12;
    }

    @Override
    public double getBuffSpeed() {
        return 50;
    }
}
