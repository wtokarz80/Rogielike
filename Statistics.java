
public class Statistics {
    int lvl;
    int exp;
    int expToLvl;
    int currentHP;
    int maxHP;
    int str;
    int attack;
    int def;

    public Statistics(int lvl, int exp, int expToLvl, int currentHP, int maxHP, int str, int attack, int def){
        this.lvl = lvl;
        this.exp = exp;
        this.expToLvl = expToLvl;
        this.currentHP = currentHP;
        this.maxHP = maxHP;
        this.str = str;
        this.attack = attack;
        this.def = def;
    }

    public int getLvl(){ 
        return lvl;
    }

    public int getExp(){
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

    public void setCurrentHP(int currentHP){
        this.currentHP = currentHP;
    }

    public int getStr(){ 
        return str;
    }

    public void setStr(int str){
        this.str = str;
    }

    public int getAttack(){ 
        return attack;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getDef(){ 
        return def;
    }

    public void setDef(int def){
        this.def = def;
    }

}
