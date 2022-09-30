import java.util.Random;

public class Snake extends Obstacle {
    private static Random random = new Random();
    private static int possRn = random.nextInt(20);
    public Snake() {
        super(4,"Yılan",5,12,7);
    }


}
