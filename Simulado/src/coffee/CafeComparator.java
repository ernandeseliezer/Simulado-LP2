package coffee;

import java.util.Comparator;

public class CafeComparator implements Comparator<Cafe> {

    @Override
    public int compare(Cafe c1, Cafe c2) {
        if (c1.calculaNota() != c2.calculaNota()) {
            return Double.compare(c2.calculaNota(), c1.calculaNota());
        }
        return c1.getNome().compareTo(c2.getNome());
    }

}