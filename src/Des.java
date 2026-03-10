import java.util.Random;

public class Des {
	private Random random;

    public int lancerDes() {
        int n1 = random.nextInt(6) + 1;
        int n2 = random.nextInt(6) + 1;

        return n1 + n2;
    }
}
