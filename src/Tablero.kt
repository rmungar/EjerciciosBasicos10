class Tablero() {
    var contenido = listOf<MutableList<String>>(
        mutableListOf<String>(" ", " ", " "),
        mutableListOf<String>(" ", " ", " "),
        mutableListOf<String>(" ", " ", " ")
    )

    fun imprimirTablero() {
        for (columna in contenido) {
            for (espacio in columna) {
                print("| ")
                print("$espacio | ")
            }
            println()
        }
    }
    fun colocarFicha(ficha: Ficha): Boolean{
        if (ficha.posx < 0||ficha.posx > 3 || ficha.posy < 0 || ficha.posy > 3){
            println("Creo que las fichas se colocan en el tablero, no fuera")
            return false
        }
        else if (contenido[ficha.posx-1][ficha.posy-1] == " "){
            contenido[ficha.posx-1][ficha.posy-1] = ficha.tipo
            return true
        }
        else{
            println("No se puede colocar una ficha ahí")
            return false
        }
    }
    fun reset(tablero: Tablero){
        tablero.contenido = listOf<MutableList<String>>(
            mutableListOf<String>(" ", " ", " "),
            mutableListOf<String>(" ", " ", " "),
            mutableListOf<String>(" ", " ", " ")
        )
    }
}