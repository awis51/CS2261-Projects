package umsl.edu.Project5;

abstract class Animal extends creature{
    @Override
    public String eatFood() {
        return ("ingestion");
    }

    @Override
    public String modeOfReproduction() {
        return ("Sexual Reproduction");
    }
}
