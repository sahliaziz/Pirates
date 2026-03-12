import java.util.Random;

public class Des {

    private Random random;
    private int dernierResultat;

    public Des() {
        random = new Random();
    }

    public int lancerDes() {
        int n1 = random.nextInt(6) + 1;
        int n2 = random.nextInt(6) + 1;
        int resultat = n1 + n2;

        dernierResultat = resultat;

        return resultat;
    }

    public int getDernierResultat() {
        return dernierResultat;
    }
}
