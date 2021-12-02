package umsl.edu.Project5;

abstract class Plant extends creature{
    @Override
    public String eatFood() {
        return ("sunlight (aka photosynthesis)");
    }

    @Override
    public String modeOfReproduction() {
        return ("Seeds");
    }
}
