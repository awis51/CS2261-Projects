package umsl.edu.Project5;

import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args){

        System.out.println("Animals set:");
        Set<Object> Animals = new HashSet<>();
        Animals.add(new dog());
        Animals.add(new cat());
        for(Object a : Animals){
            System.out.println(a.toString());
        }
        System.out.println("Plants set:");

        Set<Object> Plants = new HashSet<>();
        Plants.add(new mango());
        Plants.add(new carrot());
        for(Object p : Plants){
            System.out.println(p.toString());
        }
        System.out.println("Fungi set:");

        Set<Object> Fungi = new HashSet<>();
        Fungi.add(new mold());
        Fungi.add(new yeast());
        for(Object f : Fungi){
            System.out.println(f.toString());
        }




    }
}
