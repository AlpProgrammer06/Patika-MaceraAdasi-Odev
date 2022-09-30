public class Quarry extends BatleLoc{
    private Obstacle obstacle;

    public Quarry(Player player0){
        super(6,player0,"Snake",Quarry.getobstacle(),"Savaş ganimeti",2);
    }


    public static Obstacle getobstacle() {
        return new Snake();
    }
}
