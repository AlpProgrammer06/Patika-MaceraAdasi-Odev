import java.util.Random;
import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private String charName;
    private int demage;
    private int healty;
    private int orijinalHealth;
    private int mony;
    private Inventory inventory;
    private Location location = null;

    Scanner scanner = new Scanner(System.in);


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }


    public void selectChar() {


        System.out.println("==============KARAKTERLER=================");

        GameChar[] gameChar = {new Samurai(), new Archer(), new Knight()};

        for (GameChar gameChar1 : gameChar) {

            System.out.println("id = " + gameChar1.getId() +
                    " karakter = " + gameChar1.getCharName() +
                    " Hasarı = " + gameChar1.getdemage() +
                    " Sağlığı = " + gameChar1.getHealt());


        }
        System.out.println("===========================================");
        System.out.print(" Oynamak istediğiniz bir karakteri seçiniz = ");
        int selectChar = scanner.nextInt();


        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());                 // şimdilik bir default değer verdik 1 2 3 den farklı bir sayı seçerse program patlamasın istedik. burası daha sonra algoritmalar ile desteklenecek
                break;
        }


        System.out.println(" Karakter  = " + this.getCharName() +
                ", Hasar   = "   + this.getDemage() +
                ", Sağlığı = " + getHealty() +
                ", Parası  = "  + this.getMony());

        System.out.print("====================================");
    }


    public void initPlayer(GameChar gamechar) {
        this.setCharName(gamechar.getCharName());
        this.setDemage(gamechar.getdemage());
        this.setHealty(gamechar.getHealt());
        this.setMony(gamechar.getMony());

    }

    public void getInfo() {
        System.out.println(" Silahınız : " + getInventory().getWeapon().getName() +
                "  Zırh     : " + getInventory().getArmor().getName() +
                "  Bloklama  : " + getInventory().getArmor().getBlock() +
                ", hasarınız  : " + getDemage() +
                ", sağlığınız  :" + getHealty() +
                ", paranız    : " + getMony());
    }

    public void selectLocation() {
        while (true) {
            System.out.println();
            System.out.println("---------------------------");
            System.out.println(" Bir Bölge seçiniz !");
            System.out.println("  Bölgeler: ");
            Location[] locations = {new SafeHouse(this), new ToolStore(this),
                    new Cave(this), new River(this),
                    new Forest(this), new Quarry(this),};
            for (Location locationn : locations) {
                System.out.println(locationn.getId() + " bölge:  " + locationn.getName());
            }
            System.out.println("Lütfen seçiminizi yapınız: ");
            int noLoc = scanner.nextInt();
            switch (noLoc) {
                case 0:
                    location = null;
                case 1:
                    location = new SafeHouse(this);
                    break;
                case 2:
                    location = new ToolStore(this);
                    break;
                case 3:
                    location = new Cave(this);
                case 4:
                    location = new River(this);
                case 5:
                    location = new Forest(this);
                case 6:
                    Quarry quarry = new Quarry(this);
                    location = new Quarry(this);
                case 7:
                    System.out.println(" Geçerli bir bölgeyi seçmediniz Güvenli eve gidiliyor.");
                    location = new SafeHouse(this);
                    break;
            }
        }
    }
    public void isDelete(int choose){
        if(location.isSelectCombatValue()){
            System.out.println("Bu bölgedeki canavarları hepsi öldü başka bir bölge seçin.");

        }
    }


    public void initLocation(Location location) {

        this.setName(location.getName());

    }


    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }

    public int getTotalDemage() {
        return demage + this.demage + getInventory().getWeapon().getDemage();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getDemage() {
        return this.demage + getInventory().getWeapon().getDemage();
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }

    public int getHealty() {
        return this.healty;
    }

    public void setHealty(int healty) {
        this.healty = healty;

    }

    public int getMony() {
        return this.mony;
    }

    public void setMony(int mony) {
        this.mony = mony;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;

    }
    public void awardForQarry(int possib){
        Weapon[] weapons =
                {

                        Weapon.getWeaponObjById(3),
                        Weapon.getWeaponObjById(3),
                        Weapon.getWeaponObjById(2),
                        Weapon.getWeaponObjById(2),
                        Weapon.getWeaponObjById(2),
                        Weapon.getWeaponObjById(1),
                        Weapon.getWeaponObjById(1),
                        Weapon.getWeaponObjById(1),
                        Weapon.getWeaponObjById(1),
                        Weapon.getWeaponObjById(1)
                };
        Armor[] armors =
                {
                        Armor.getArmorObjById(3),
                        Armor.getArmorObjById(3),
                        Armor.getArmorObjById(2),
                        Armor.getArmorObjById(2),
                        Armor.getArmorObjById(2),
                        Armor.getArmorObjById(1),
                        Armor.getArmorObjById(1),
                        Armor.getArmorObjById(1),
                        Armor.getArmorObjById(1),
                        Armor.getArmorObjById(1)
                };

        int money[] = {1,1,1,1,1,5,5,5,10,10};

        Random random = new Random();
        int possRn = possib;
        int percent;
        if(possRn < 3){
            percent = random.nextInt(10);
            Weapon weapon = weapons[percent];
            System.out.println("Tbrikler! Silah kazandınız.");
            System.out.println("Önceki silahınız: " + this.getInventory().getWeapon().getName());
            this.getInventory().setWeapon(weapon);
            System.out.println("Yeni silahınız: " + this.getInventory().getWeapon().getName());

        }
        else if(2<possRn  || possRn < 6){
            percent = random.nextInt(10);
            Armor armor = armors[percent];
            System.out.println("Terikler! Zırh kazandınız.");
            System.out.println("Önceki silahınız: " + this.getInventory().getArmor().getName());
            this.getInventory().setArmor(armor);
            System.out.println("Yeni silahınız: " + this.getInventory().getArmor().getName());
        }
        else if (5 < possRn || possRn<11){
            percent = random.nextInt(10);
            int gain = money[percent];
            System.out.println("Tebrikler! Altın kazandınız.");
            System.out.println("Önceki paranız: " + this.getMony() + " altın");
            this.setMony(this.getMony() + gain);
            System.out.println("yeni paranız: " + getMony() + " altın");
        }
        else{
            System.out.println("Malesef hiçbir şey kazanamadınız!");
        }
    }



}
