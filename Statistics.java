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

    public int get_player_lvl(){
        return lvl;
    }

    public int get_player_Experience(){
        return exp;
    }

    public int get_player_ExpToLvl(){
        return expToLvl;
    }

	public int get_Max_HP(){
        return maxHP;
    }

    public int get_player_Current_HP(){
        return currentHP;
    }

}
