public class Exit extends NormLoc{

    public Exit(Player player, String name) {
        super(1,player, name);
    }
    public boolean onLocation() {
        System.out.println("Çıkış yapıldı");
        return true;
    }
}
