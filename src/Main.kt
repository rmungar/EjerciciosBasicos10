fun main() {
    try {
        val tablero = Tablero()
        val partida = Juego()
        partida.juego(tablero)
    }
    catch (e:Exception) {
        print(e.message)
    }
}