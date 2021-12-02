package umsl.edu.Project5;

public class cat extends Animal{
    @Override
    public String toString() {
        String digestion = eatFood();
        String reproduction = modeOfReproduction();
        StringBuilder str = new StringBuilder();
        str.append("I'm a cat, a type of Animal. Meeeeooow! I eat food by ");
        str.append(digestion);
        str.append(" and reproduce by ");
        str.append(reproduction);
        str.trimToSize();
        String results = str.toString();
        return results;
    }
}
