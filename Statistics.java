public class Statistics {
    int lvl;
    int exp;
    int expToLvl;
    int currentHP;
    int maxHP;
    int defence;
    int strength;
    int attack;
    public Statistics(int lvl, int exp, int expToLvl, int currentHP, int maxHP, int defence, int strength, int attack){
        this.lvl = lvl;
        this.exp = exp;
        this.expToLvl = expToLvl;
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        this.defence = defence;
        this.strength = strength;
        this.attack = attack;
    }

    public int getLvl(){
        return lvl;
    }

    public int getExperience(){
        return exp;
    }

    public int getExpToLvl(){
        return expToLvl;
    }

	public int getMaxHP(){
        return maxHP;
    }

    public int getCurrentHP(){
        return currentHP;
    }

}
