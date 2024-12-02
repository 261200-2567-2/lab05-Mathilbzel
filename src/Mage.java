public class Mage implements Job {
    @Override
    public void applyJobBonuses(Hero hero) {
        hero.setMaxHp(hero.getMaxHp() + 10); // Mage has moderate HP
        hero.setMaxMana(hero.getMaxMana() + 25); // Mage has more mana
        hero.setCurrSpeed(hero.getCurrSpeed() + 1); // Slight speed boost
    }
}
