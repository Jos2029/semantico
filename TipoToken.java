package semantico;
public enum TipoToken {
    // Crear un tipoToken por palabra reservada
    // Crear un tipoToken: identificador, una cadena y numero
    // Crear un tipoToken por cada "Signo del lenguaje" (ver clase Scanner)

    // Palabras reservadas:
    SELECT, DISTINCT, FROM,

    // Palabras clave:
    Y, CLASE, IF, FOR, WHILE, VAR, PRINT, ELSE, RETURN, AND, OR, DIFERENTE_DE, SUPER, 
    TRUE, FALSE, NULL, THIS, STRING, 

    // Simbolos
    PUNTO_COMA, COMA, PARENTESIS_ABRE, PARENTESIS_CIERRA, MAYOR_O_IGUAL, MAYOR_QUE,ASTERISCO,SUMA,RESTA,
    MENOR_O_IGUAL, MENOR_QUE, NUMBER, IGUAL, VARIABLE, OTRO,PUNTO, CORCHETE_ABRE, CORCHETE_CIERRA, COMPARACION,
    ADMIRACION_CIERRA, GUION,

    //Funciones Analizador
    DECLARATION, CLASS_DECL, FUN_DECL, VAR_DECL, CLASS_INHER, VAR_INIT, FUNCTIONS, FUNCTION, 
    EXPR_STMT, FOR_STMT, IF_STMT, PRINT_STMT, RETURN_STMT, WHILE_STMT, BLOCK, EXPRESSION, 
    FOR_STMT1, FOR_STMT2, FOR_STMT3, ELSE_STATEMENT, RETURN_EXP_OPC, BLOCK_DECL, ASSIGNMENT,
    LOGIC_OR, ASSIGNMENT_OPC, LOGIC_AND, LOGIC_OR_2, EQUALITY, LOGIC_AND_2, COMPARISON, EQUALITY_2,
    TERM, COMPARISON_2, FACTOR, TERM_2, UNARY, CALL, PRIMARY, CALL_2, ARGUMENTS_OPC, CALL_OPC,
    PARAMETERS_OPC, PARAMETERS, PARAMETERS_2, ARGUMENTS, ARGUMENTS_2, CLASS, FUN, STATEMENT,
    PRINTF_STMT,

    //ARBOL
    LPAREN, RPAREN, LBRACE, RBRACE,


    IDENTIFICADOR,
    // Final de cadena
    EOF
}
