package semanticoprueba2;

public class SolverAritmetico {

    private final Nodo nodo;

    public SolverAritmetico(Nodo nodo) {
        this.nodo = nodo;
    }

    public Object resolver(){
        return resolver(nodo);
    }
    private Object resolver(Nodo n){
        // No tiene hijos, es un operando
        if(n.getHijos() == null){
            if(n.getValue().tipo == TipoToken.NUMBER || n.getValue().tipo == TipoToken.STRING)
            {
                return n.getValue().literal;
            }
            else if(n.getValue().tipo == TipoToken.IDENTIFICADOR)
            {
                // Ver la tabla de símbolos
                //se busca si la variable existe, se llama a la función "Existe identificador"
                if(TablaSimbolos.existeIdentificador(n.getValue().tipo) == true)
                {
                    return TablaSimbolos.obtener(n.getValue().tipo);
                }
                else
                {
                    System.out.println("No existe: " + n.getValue().tipo);
                }
            }
            else if(n.getValue().tipo == TipoToken.TRUE)
            {
                return true;
            }
            else if(n.getValue().tipo == TipoToken.FALSE)
            {
                return false;
            }
        }

        // Por simplicidad se asume que la lista de hijos del nodo tiene dos elementos
        Nodo izq = n.getHijos().get(0);
        Nodo der = n.getHijos().get(1);

        Object resultadoIzquierdo = resolver(izq);
        Object resultadoDerecho = resolver(der);

        if(resultadoIzquierdo instanceof Double && resultadoDerecho instanceof Double){
            switch (n.getValue().tipo){
                case SUMA:
                    return ((Double)resultadoIzquierdo + (Double) resultadoDerecho);
                case RESTA:
                    return ((Double)resultadoIzquierdo - (Double) resultadoDerecho);
                case ASTERISCO: //MULTIPLICACION
                    return ((Double)resultadoIzquierdo * (Double) resultadoDerecho);
                case GUION: //DIVISION
                    return ((Double)resultadoIzquierdo / (Double) resultadoDerecho);
                case MENOR_QUE:
                    return((Double)resultadoIzquierdo < (Double) resultadoDerecho);
                case MENOR_O_IGUAL:
                    return((Double)resultadoIzquierdo <= (Double) resultadoDerecho);
                case MAYOR_QUE:
                    return((Double)resultadoIzquierdo > (Double) resultadoDerecho);
                case MAYOR_O_IGUAL:
                    return((Double)resultadoIzquierdo >= (Double) resultadoDerecho);
                case COMPARACION:
                    return (((Double)resultadoIzquierdo).equals((Double) resultadoDerecho)); // se usa equals para comparar si son iguales
                case ADMIRACION_CIERRA:
                    return (!((Double)resultadoIzquierdo).equals((Double) resultadoDerecho)); // se usa equals para comparar si son diferentes
                case IGUAL: // revisar si son iguales para poderlo agregar a la tabla de símbolos
                    if(izq.getValue().tipo == TipoToken.IDENTIFICADOR) // se revisa si el nodo izquierdo es un identificador para que sea correcto asignarlo
                    {
                        TablaSimbolos.asignar(izq.getValue().tipo, resultadoDerecho); // se asigna el valor
                    } 
                    
            }
        }
        else if(resultadoIzquierdo instanceof String && resultadoDerecho instanceof String){
            if (n.getValue().tipo == TipoToken.SUMA){
                // Ejecutar la concatenación
                //resultadoIzquierdo.concat(resultadoDerecho);
                return (String) resultadoIzquierdo + resultadoDerecho;
            }
            else{
                System.out.println("No coincide el tipo de dato");
            }
        }
        
        else{
            // Error por diferencia de tipos
            System.out.println("El tipo de dato es distinto");
        }

        return null;
    }
}
