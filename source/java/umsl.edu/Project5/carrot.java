package umsl.edu.Project5;

public class carrot extends Plant{
    @Override
    public String toString() {
        String digestion = eatFood();
        String reproduction = modeOfReproduction();
        StringBuilder str = new StringBuilder();
        str.append("I'm a carrot, a type of Plant. I am very nutritious. I eat food by ");
        str.append(digestion);
        str.append(" and reproduce by ");
        str.append(reproduction);
        str.trimToSize();
        String results = str.toString();
        return results;
    }
}
