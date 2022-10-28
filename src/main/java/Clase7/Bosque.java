package Clase7;

import java.util.ArrayList;

public class Bosque {
    private ArrayList<Arbol> bosque = new ArrayList<>();

    public Bosque() {
        this.bosque = new ArrayList<>();
    }

    public Bosque(ArrayList<Arbol> bosque) {
        this.bosque = bosque;
    }

    public void agregarArbol(Arbol a){
        bosque.add(a);
    }

    public ArrayList<Arbol> getBosque(){return bosque;}
}
