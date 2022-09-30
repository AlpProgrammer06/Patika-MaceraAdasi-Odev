public class NormLoc extends Location {
    public NormLoc(int id, Player player, String name) {
        super(id, player, name);
    }

    @Override
    boolean onlocation() {
        return true;
    }

    @Override
    public boolean isSelectCombatValue() {
        return false;
    }

    @Override
    public void setSelectCombatValue() {

    }

    @Override
    public void setSelectCombatValue(boolean selectCombatValue) {

    }


}







