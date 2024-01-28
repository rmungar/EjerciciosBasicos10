class Tablero() {
    var contenido = listOf<MutableList<String>>(
        mutableListOf<String>("", "", ""),
        mutableListOf<String>("", "", ""),
        mutableListOf<String>("", "", "")
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
    fun colocarFicha(ficha: Ficha){
        contenido[ficha.posx][ficha.posy] = ficha.tipo
    }
}