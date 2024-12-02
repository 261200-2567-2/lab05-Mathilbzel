public class Main {
    public static void main(String[] args) {
        // Create Jobs (assuming Warrior and Mage are defined somewhere)
        Job warrior = new Warrior(); // Example of a Warrior job
        Job mage = new Mage(); // Example of a Mage job

        // Create Heroes with jobs
        Hero me = new Hero("Me", 2, 100.0, warrior); // Hero with Warrior job
        me.printStatus(); // Print initial status
        Shield gay = new Shield(10, 50.0);
        me.equipShield(gay); // Equip shield
        me.printStatus(); // Print after equipping shield

        me.levelUp(); // Level up
        me.printStatus(); // Print after leveling up

        Hero fai = new Hero("Fai", 10, 120.0, mage); // Hero with Mage job
        fai.printStatus(); // Print Fai's initial status

        // Equip sword and make attack
        Sword holyGrail = new Sword(10, 100.0);
        fai.equipSword(holyGrail); // Equip sword to Fai
        fai.swordAttack(me); // Fai attacks Me
        me.printStatus(); // Print Me's status after attack
        fai.printStatus(); // Print Fai's status after attack

        // Level up shield and sword
        me.getShield().levelUp();
        me.printStatus(); // Print Me's status after shield level-up
        fai.getSword().levelUp();
        fai.printStatus(); // Print Fai's status after sword level-up

        // Fai attacks Me again
        fai.swordAttack(me);
        me.swordAttack(fai); // Me attacks Fai

        // Equip Accessories
        Accessory bloodRing = new BloodRing(); // Example accessory
        me.equipAccessory(bloodRing); // Equip accessory to Me
        me.printStatus(); // Print after equipping accessory

        Accessory windBracelet = new WindBracelet(); // Another accessory example
        fai.equipAccessory(windBracelet); // Equip accessory to Fai
        fai.printStatus(); // Print after equipping accessory
    }
}
