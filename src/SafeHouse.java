public class SafeHouse extends NormLoc{


    public SafeHouse(Player player) {
        super(1,player,"Güvenli Ev");

    }

    @Override
   public boolean onlocation() {
        System.out.println("Güvenli evdesiniz !");
        System.out.println("Canınız yenilendi ");
        this.getPlayer().setHealty(this.getPlayer().getOrijinalHealth());
        return true;
    }
}
