fun main() {
    try {
        val Tablero1 = Tablero()
        val partida = Juego()
        partida.juego(Tablero1)
    }
    catch (e:Exception) {
        print(e.message)
    }
}