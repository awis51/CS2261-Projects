package umsl.edu.Project5;

abstract class Fungi extends creature{
    @Override
    public String eatFood() {
        return ("external digestion with hyphae");
    }

    @Override
    public String modeOfReproduction() {
        return ("Spores");
    }
}
