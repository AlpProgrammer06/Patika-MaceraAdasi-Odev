import java.util.Random;

public class BatleLoc extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;
    private String selectCombat;
    private boolean selectCombatValue;

    public BatleLoc(int id , Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(id,player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;

    }

    @Override
    boolean onlocation() {
        int obsNumber = this.ramdomObstacle();
        System.out.println(this.getPlayer().getName() + " şu an buradasınız : " + getName() );
        System.out.println(" Dikkatli ol ! Burada " + obsNumber + " tane " +
                this.getObstacle().getName() + " yaşıyor");
        boolean continueEx = true;

        while (continueEx) {
            System.out.println("<S> Savaş veya <K> Kaç");
            String selecCase = scanner.nextLine();
            selecCase = selecCase.toUpperCase();
            if (selecCase.equals("S")) {
                if (combat(getMaxObstacle())) {
                    break;
                } else {
                    System.out.println("öldünüz !");
                    return false;
                }
            }


            if (this.getPlayer().getHealty() <= 0) {
                System.out.println(" ÖLDÜNÜZ !");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int obsNumber) {
        Random random = new Random();

        for (int i = 1; i < obsNumber; i++) {
            this.getObstacle().setHealty(this.getObstacle().getOrijinalHealt());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealty() > 0 && this.getObstacle().getHealty() > 0) {
                int priotiry = random.nextInt(2);
                System.out.print(" <V> vur veya <K> kaç");
                String selectCombat = scanner.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    if (priotiry == 0) {
                        System.out.println(" Vurdunuz ! " + " öncelik " + (priotiry));
                        this.getObstacle().setHealty(this.getObstacle().getHealty() -
                                this.getPlayer().getTotalDemage());
                        afterHit();
                    } else {
                        if (this.getObstacle().getHealty() > 0) {
                            System.out.println();
                            System.out.println(this.getObstacle().getName() +
                                    " size vurdu " + " öncelik " + (priotiry));
                            int obstacleDamage = this.getObstacle().getDemage() -
                                    this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealty(this.getPlayer().getHealty() - obstacleDamage);
                            afterHit();
                        }

                    }
                    this.setSelectCombatValue(true);
                } else if (selectCombat.equals(" K ")) {
                    afterHit();
                    this.setSelectCombatValue(false);
                    return true;
                }
            }
        }
        if (this.getPlayer().getHealty() > this.getObstacle().getHealty()) {
            System.out.println(" Düşmanı Yendiniz ! ");
            if (this.getObstacle().getName().equals(" yılan ")) {
                Player player = this.getPlayer();
                 player.awardForQarry(this.getObstacle().getAward());
                this.setSelectCombatValue(true);
                return true;
            } else {
                int totalGain = this.getObstacle().getAward() * getMaxObstacle();
                System.out.println(totalGain + " Altın ödülünü kazandınız ! ");
                System.out.println(" Önceki Paranız : " + this.getPlayer().getMony());
                this.getPlayer().setMony(this.getPlayer().getMony() + totalGain);
                System.out.println(this.getPlayer().getName() + " Bölgesinde tüm düşmanları yendiniz ! ");
                System.out.println(" Artık bu bölge temizlendi. ");
              //  System.out.println(" Bu seçim değeri : " + isSelectCombatValue());
                //hayatta
                this.setSelectCombatValue();
                return true;
            }
        } else {
            // öldü
            return false;
        }
    }



    public void playerStats() {
        System.out.println("Oyuncu değerleri ");
        System.out.println("----------------");
        System.out.println(" Sağlık : " + this.getPlayer().getHealty());
        System.out.println(" Silah  : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println(" Zırh   : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println(" Bloklama   : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println(" Hasar  : " + this.getPlayer().getTotalDemage());
        System.out.println(" Sağlık : " + this.getPlayer().getMony());
        System.out.println();


    }

    public void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getHealty());
        System.out.println(this.getObstacle().getName() + " canı " + this.getObstacle().getHealty());
        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println(i + this.getObstacle().getName() + "Değerleri ");
        System.out.println("----------------------------");
        System.out.println("Sağlık" + this.getObstacle().getHealty());
        System.out.println("Hasar" + this.getObstacle().getDemage());
        System.out.println("Ödül" + this.getObstacle().getAward());
    }
    public int ramdomObstacle() {
        Random r = new Random();

        return r.nextInt(this.maxObstacle) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }



    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;

    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;

    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;

    }


    public String getSelectCombat() {
        return selectCombat;
    }

    public void setSelectCombat(String selectCombat) {
        this.selectCombat = selectCombat;
    }
    @Override
    public boolean isSelectCombatValue(){
        return selectCombatValue;
    }

    @Override
    public void setSelectCombatValue() {

    }


    @Override
    public void setSelectCombatValue(boolean selectCombatValue){
        this.selectCombatValue =selectCombatValue;
    }
}
