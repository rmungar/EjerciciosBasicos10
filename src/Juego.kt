class Juego {
    fun juego(tablero: Tablero){
        var win: Boolean? = null
        var ronda = 1
        val tipos = mutableListOf<String>("Cara","Cruz")
        val jugadores = elegirTipo(tipos)
        var jugar = true
        while (jugar) {
            win = turnoJ1(tablero, ronda, jugadores)
            if (win == true){
                print("J1 GANA")
                break
            }
            win = turnoJ2(tablero, ronda, jugadores)
            if (win == true){
                print("J2 GANA")
                break
            }
            ronda += 1
            if (ronda >= 5) {
                println("¿Quereís seguir jugando? (s/n)")
                val respuesta = readln().lowercase()
                if (respuesta == "s") {
                    tablero.reset(tablero)
                } else if (respuesta == "n") {
                    jugar = false
                }
            }
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * elegirTipo se encarga unicamente de asignar Cara o Cruz a J1 en la primera ronda, puesto que J2 será el que J1 no quiera.
     * @param tipos -> Lista sencilla con "Cara" y "Cruz" dentro.
     * @return J1 -> La opción que ha seleccionado J1.
     */
    private fun elegirTipo(tipos: MutableList<String>): MutableList<MutableList<String>> {
        val jugadores = mutableListOf<MutableList<String>>()
        val J2 = mutableListOf<String>()
        val J1 = mutableListOf<String>()
        var elegido = false
        while (!elegido) {
            print("J1, ¿Quieres ser cara o cruz? ")
            val tipo = readln().lowercase().replaceFirstChar { it -> it.uppercase() }
            when (tipo) {
                "Cara" -> {
                    J1.add(tipos[0])
                    tipos.remove("Cara")
                    J2.add(tipos[0])
                    jugadores.add(J1)
                    jugadores.add(J2)
                    elegido = true
                }
                "Cruz" -> {
                    J1.add(tipos[1])
                    tipos.remove("Cruz")
                    J2.add(tipos[0])
                    jugadores.add(J1)
                    jugadores.add(J2)
                    elegido = true
                }
                else -> {
                    println("No existe esa ficha")
                }
            }
        }
        return jugadores
    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * turnoJ1 recoge el flujo de acciones que el J1 realiza en su turno
     * @param tablero -> Tablero de juego.
     * @param ronda -> Entero que representa la ronda actual
     * @param jugadores -> Lista con el tipo de ficha de J1 y J2.
     */
    private fun turnoJ1(tablero: Tablero, ronda:Int, jugadores: MutableList<MutableList<String>>): Boolean? {
        var win: Boolean? = null
        val movimiento = false
        println("  --Turno J1--  ")
        while (!movimiento) {
            tablero.imprimirTablero()
            print("¿Dónde quieres colocar la ficha? ")
            val posiciones = readln().split("-")
            val ficha = Ficha(posiciones[0].toInt(), posiciones[1].toInt(), jugadores[0][0])
            val mov = tablero.colocarFicha(ficha)
            win = comprobarGanador(tablero, ficha, ronda)
            if (win == true){
                print("J1 GANA")
                tablero.imprimirTablero()
                break
            }
            if (mov) break
        }
        return win
    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * turnoJ2 recoge el flujo de acciones que el J2 realiza en su turno
     * @param tablero -> Tablero de juego.
     * @param ronda -> Entero que representa la ronda actual
     * @param jugadores -> Lista con el tipo de ficha de J1 y J2.
     */
    private fun turnoJ2(tablero: Tablero, ronda: Int, jugadores: MutableList<MutableList<String>>): Boolean? {
        var win: Boolean? = null
        val movimiento = false
        println("  --Turno J2--  ")
        while (!movimiento) {
            tablero.imprimirTablero()
            print("¿Dónde quieres colocar la ficha? ")
            val posiciones = readln().split("-")
            val ficha = Ficha(posiciones[0].toInt(), posiciones[1].toInt(), jugadores[1][0])
            val mov = tablero.colocarFicha(ficha)
            win = comprobarGanador(tablero, ficha, ronda)
            if (win == true){
                print("J2 GANA")
                tablero.imprimirTablero()
                break
            }
            if (mov) break
        }
        return win
    }
    //------------------------------------------------------------------------------------------------------------------

    private fun comprobarGanador(tablero: Tablero, ficha: Ficha, ronda: Int) : Boolean? {
        var win = false
        if (ronda > 3) {
            for (i in 1..3) {
                if (tablero.contenido[i][0].isNotBlank() == tablero.contenido[i][1].isNotBlank() && tablero.contenido[i][1].isNotBlank() == tablero.contenido[i][2].isNotBlank()) {
                    win = true
                    return win
                } else if (tablero.contenido[0][i].isNotBlank() == tablero.contenido[1][i].isNotBlank() && tablero.contenido[1][i].isNotBlank() == tablero.contenido[2][i].isNotBlank()) {
                    win = true
                    return win
                } else if (tablero.contenido[0][0].isNotBlank() == tablero.contenido[1][1].isNotBlank() && tablero.contenido[1][1].isNotBlank() == tablero.contenido[2][2].isNotBlank()) {
                    win = true
                    return win
                } else if (tablero.contenido[0][2].isNotBlank() == tablero.contenido[1][1].isNotBlank() && tablero.contenido[1][1].isNotBlank() == tablero.contenido[2][0].isNotBlank()) {
                    win = true
                    return win
                } else {
                    win = false
                    return win
                }
            }
        }
        return null
    }
}