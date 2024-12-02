import java.util.ArrayList;

public class Hero {
    private String name;
    private int level;
    private double currMana, maxMana, currHp, maxHp;
    private double currSpeed, baseSpeed;
    private ArrayList<Accessory> accessories; // List to store accessories
    private Sword sword;
    private Shield shield;

    // Job-related attributes
    private Job job;

    public Hero(String name, int level, double speed, Job job) {
        this.name = name;
        this.level = level;
        this.maxHp = 100 + 10 * level;
        this.currHp = maxHp;
        this.maxMana = 50 + 2 * level;
        this.currMana = maxMana;
        this.baseSpeed = speed;
        this.currSpeed = baseSpeed;
        this.accessories = new ArrayList<>();
        this.job = job;

        // Apply job bonuses to stats
        job.applyJobBonuses(this);
    }

    // Method to level up the hero
    public void levelUp() {
        level++;
        baseSpeed += 10;
        updateStatus();
        this.currHp = maxHp;
        this.currMana = maxMana;
    }

    // Method to equip a sword
    public void equipSword(Sword sword) {
        this.sword = sword;
        this.currSpeed += sword.getRunDecrease();
        sword.setOwner(this);
    }

    // Method to equip a shield
    public void equipShield(Shield shield) {
        this.shield = shield;
        this.currSpeed += shield.getRunDecrease();
        shield.setOwner(this);
    }

    // Method to equip an accessory
    public void equipAccessory(Accessory accessory) {
        if (this.currHp <= 0) {
            System.out.println(name + " is already dead, cannot equip.");
        }else {
            this.accessories.add(accessory);
            applyAccessoryBonuses(accessory);
            System.out.println(name + " equipped " + accessory.getName());
        }
        }

    // Method to apply accessory bonuses to hero stats
    private void applyAccessoryBonuses(Accessory accessory) {
        this.maxHp += accessory.getBuffHp();
        this.maxMana += accessory.getBuffMana();
        this.currSpeed += accessory.getBuffSpeed();
    }

    // Method to perform an attack
    public void swordAttack(Hero target) {
        if (this.currHp <= 0) {
            System.out.println(name + " cannot attack, already defeated.");
        } else if (this.sword != null) {
            target.receiveDamage(this.sword.damage());
        } else {
            System.out.println(name + " doesn't have a sword to attack with.");
        }
    }

    // Method to receive damage from an attack
    public void receiveDamage(double damage) {
        double defense = (shield != null) ? shield.defense() : 0;
        double finalDamage = Math.max(0, damage - defense);
        this.currHp -= finalDamage;

        if (this.currHp <= 0) {
            this.currHp = 0;
            System.out.println(name + " has been defeated.");
        }
    }

    // Method to update stats based on level and equipment
    public void updateStatus() {
        maxHp = 100 + 10 * level;
        maxMana = 50 + 2 * level;
        if (sword != null) {
            currSpeed = baseSpeed + sword.getRunDecrease();
        }
        if (shield != null) {
            currSpeed = baseSpeed + shield.getRunDecrease();
        }
    }

    // Print the hero's current status
    public void printStatus() {
        System.out.println("Hero Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Job: " + getJobName());
        System.out.println("Current HP: " + currHp + "/" + maxHp);
        System.out.println("Current Mana: " + currMana + "/" + maxMana);
        System.out.println("Speed: " + currSpeed);

        if (sword != null) {
            System.out.println("Sword Damage: " + sword.damage());
        } else {
            System.out.println("Sword: None");
        }

        if (shield != null) {
            System.out.println("Shield Defense: " + shield.defense());
        } else {
            System.out.println("Shield: None");
        }

        // Print accessories
        if (!accessories.isEmpty()) {
            System.out.println("Equipped Accessories:");
            for (Accessory accessory : accessories) {
                System.out.println(" - " + accessory.getName());
            }
        }
        System.out.println("******************************************");
    }

    // Getter and Setter for job
    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
        job.applyJobBonuses(this); // Reapply job bonuses when job is set
    }

    // Getters for hero stats
    public String getName() {
        return name;
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(double maxHp) {
        this.maxHp = maxHp;
    }

    public double getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(double maxMana) {
        this.maxMana = maxMana;
    }

    public double getCurrSpeed() {
        return currSpeed;
    }

    public void setCurrSpeed(double currSpeed) {
        this.currSpeed = currSpeed;
    }

    public String getJobName() {
        if (job != null) {
            return job.getClass().getSimpleName();  // Return class name (e.g., "Warrior" or "Mage")
        } else {
            return "No Job";
        }
    }

    public Sword getSword() {
        return sword;
    }

    public Shield getShield() {
        return shield;
    }
}
