public class Warrior implements Job {
    @Override
    public void applyJobBonuses(Hero hero) {
        hero.setMaxHp(hero.getMaxHp() + 20); // Warrior has more HP
        hero.setMaxMana(hero.getMaxMana() + 5); // Warrior has less mana
        hero.setCurrSpeed(hero.getCurrSpeed() + 1); // Slight speed boost
    }
}
