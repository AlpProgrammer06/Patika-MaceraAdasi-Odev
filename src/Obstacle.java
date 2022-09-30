public class Obstacle {
    private int id;
    private String name;
    private int demage;
    private int healty;
    private int award;
    private int orijinalHealt;

    public Obstacle(int id, String name, int demage, int healty , int award) {
        this.id = id;
        this.name=name;
        this.demage = demage;
        this.healty = healty;
        this.award =award;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }
    public String getName(){
        return this.name;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;

    }

    public int getHealty() {
        return healty;
    }

    public void setHealty(int healty) {
        if(healty<0){
            healty=0;
        }
        this.healty = healty;

    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;

    }

    public int getOrijinalHealt() {
        return orijinalHealt;
    }

    public void setOrijinalHealt(int orijinalHealt) {
        this.orijinalHealt = orijinalHealt;

    }
}
