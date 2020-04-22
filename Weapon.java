public class Weapon extends GameObject{
    private int str;
    private int def;
    private int attack;

    public Weapon (String name, String symbol, Coordinates pivot, int width, int height, int str, int def, int attack) {
        super(name, symbol, pivot, width, height);
        this.str = str;
        this.def = def;
        this.attack = attack;
    }

    public int getStr(){
        return str;
    }

    public void setStr(int str){
        this.str = str;
    }

    public int getDef(){
        return def;
    }

    public void setDef(int def){
        this.def = def;
    }

    public int getAttack(){
        return attack;
    }

    public void setAttack(int str){
        this.str = attack;
    }


    public void use(Player player){
        player.addItem(name);
        setPivot(new Coordinates(0, 0));
        setSymbol("\ud83e\uddf1");
        int increaseAttack = player.getStats().getAttack() + this.attack;
        int increaseDef = player.getStats().getAttack() + this.def;
        int increaseStr = player.getStats().getStr() + this.str;
        player.getStats().setAttack(increaseAttack);
        player.getStats().setDef(increaseDef);
        player.getStats().setStr(increaseStr);
    }
        
    }