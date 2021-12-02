package umsl.edu.Project5;

public class yeast extends Fungi {
    @Override
    public String toString() {
        String digestion = eatFood();
        String reproduction = modeOfReproduction();
        StringBuilder str = new StringBuilder();
        str.append("I'm yeast, a type of Fungi. I'm used in cooking and beverages. I eat food by ");
        str.append(digestion);
        str.append(" and reproduce by ");
        str.append(reproduction);
        str.trimToSize();
        String results = str.toString();
        return results;
    }
}
