package umsl.edu.Project5;

public class dog extends Animal{
    @Override
    public String toString() {
        String digestion = eatFood();
        String reproduction = modeOfReproduction();
        StringBuilder str = new StringBuilder();
        str.append("I'm a dog, a type of Animal. Bark Bark! I eat food by ");
        str.append(digestion);
        str.append(" and reproduce by ");
        str.append(reproduction);
        str.trimToSize();
        String results = str.toString();
        return results;
    }
}
