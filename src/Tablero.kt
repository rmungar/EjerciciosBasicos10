class Tablero() {
    var proporcion: Int = 3
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
}