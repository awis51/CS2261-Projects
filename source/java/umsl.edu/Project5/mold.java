package umsl.edu.Project5;

public class mold extends Fungi{
    @Override
    public String toString() {
        String digestion = eatFood();
        String reproduction = modeOfReproduction();
        StringBuilder str = new StringBuilder();
        str.append("I'm mold, a type of Fungi. I grow on your food after you leave it in the fridge for weeks. I eat food by ");
        str.append(digestion);
        str.append(" and reproduce by ");
        str.append(reproduction);
        str.trimToSize();
        String results = str.toString();
        return results;
    }
}
