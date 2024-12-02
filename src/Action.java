public class Action {
    private String name;
    private double dmg;
    private double manaCost;

    // Constructor
    public Action(String name, double dmg, double manaCost) {
        this.name = name;
        this.dmg = dmg;
        this.manaCost = manaCost;
    }

    public String getName() { return name; }
    public double getDmg() { return dmg; }
    public double getManaCost() { return manaCost; }
}
