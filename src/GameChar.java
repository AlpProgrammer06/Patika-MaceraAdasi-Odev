public abstract class GameChar {
    private int id;
    private String charName;
    private int demage;
    private int healt;
    private int mony;

    public GameChar(int id, String charName, int demage, int healt, int mony) {
        this.id = id;
        this.charName = charName;
        this.demage = demage;
        this.healt = healt;
        this.mony = mony;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;

    }

    public int getdemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;

    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        this.healt = healt;

    }

    public int getMony() {
        return mony;
    }

    public void setMony(int mony) {
        this.mony = mony;

    }


}
