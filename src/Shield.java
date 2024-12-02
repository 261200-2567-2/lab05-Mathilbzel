public class Shield {
    private int level;
    private double baseDef,runDecrease;
    private Hero owner;
    public Shield(int level,double baseDef) {
        this.level = level;
        this.baseDef = baseDef;
        this.runDecrease = -10;
    }
    public void levelUp() {
        level++;
        speedDec();
        defense();
        owner.updateStatus();
    }
    public double defense() {
        return baseDef*(1+0.05*level);
    }
    public void speedDec() {
        runDecrease *= 0.1+0.08*level;
    }
    public double getRunDecrease() {
        return runDecrease;
    }

    public void setOwner(Hero owner) {
        this.owner = owner;
    }
}
