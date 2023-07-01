package semanticoprueba2;
import java.util.ArrayList;
import java.util.List;

public class Arbol {
    private final Nodo raiz;

    public Arbol(Nodo raiz){
        this.raiz = raiz;
    }

    public void recorrer(){
        for(Nodo n : raiz.getHijos()){
            Token t = n.getValue();
            switch (t.tipo){
                // Operadores aritméticos
                case SUMA:
                case RESTA:
                case ASTERISCO: //MULTIPLICACION
                case GUION: //DIVISION
                    SolverAritmetico solver = new SolverAritmetico(n);
                    Object res = solver.resolver();
                    System.out.println(res);
                break;

                case VAR:
                    // Crear una variable. Usar tabla de simbolos
                   // asignar( , );
                    break;
                case IF:
                    break;

            }
        }
    }

}

