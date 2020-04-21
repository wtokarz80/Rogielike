
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
}

//     public int get_player_Current_HP(){
//         return player_Current_HP;
//     }

//     public int get_base_player_HP(){
//         return player_Base_HP;
//     }

//     public static void Stats_Checker(Integer player_Current_HP, Integer player_Max_HP, Integer player_Max_MP,
//             Integer player_Current_MP) {
//         if (player_Current_HP > player_Max_HP)
//         {
//             player_Current_HP = player_Max_HP;
//         }
//         if (player_Current_MP > player_Max_MP) {
//             player_Current_MP = player_Max_MP;
//         }
//     }

//     public static void lvl_Up() {
        
//     }
// }
