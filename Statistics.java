
public class Statistics {
    int lvl;
    int exp;
    int expToLvl;
    int current_HP;
    int MaxHP;
    public Statistics(int lvl, int exp, int expToLvl, int current_HP, int MaxHP){
        this.lvl = lvl;
        this.exp = exp;
        this.expToLvl = expToLvl;
        this.current_HP = current_HP;
        this.MaxHP = MaxHP;
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
        return MaxHP;
    }

    public int get_player_Current_HP(){
        return current_HP;
    }

}
