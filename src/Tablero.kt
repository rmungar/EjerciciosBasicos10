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
        if (contenido[ficha.posx-1][ficha.posy-1] == " "){
            contenido[ficha.posx-1][ficha.posy-1] = ficha.tipo
            return true
        }
        else{
            println("No se puede colocar una ficha ahí")
            return false
        }
    }
}