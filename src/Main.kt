fun main() {
    try {
        val Tablero1 = Tablero()
        Tablero1.imprimirTablero()
    }
    catch (e:Exception) {
        print(e.message)
    }
}