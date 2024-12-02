public class Sword {
    private int level;
    private double baseDmg,runDecrease;
    private Hero owner;
    public Sword(int level,double baseDmg) {
        this.level = level;
        this.baseDmg = baseDmg;
        this.runDecrease = -10;
    }
    public void levelUp() {
        level++;
        speedDec();
        damage();
        owner.updateStatus();
    }
    public double damage() {
        return baseDmg * (1 + 0.05 * level);
    }
    public void speedDec() {
        runDecrease *=0.1+0.04*level;
    }

    public double getRunDecrease() {
        return runDecrease;
    }

    public void setOwner(Hero owner) {
        this.owner = owner;
    }
}
