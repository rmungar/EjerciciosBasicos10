class Juego {
    fun juego(tablero: Tablero) {
        var win: Boolean? = null
        var ronda = 0
        val tipos = mutableListOf<String>("Cara", "Cruz")
        val jugadores = elegirTipo(tipos)
        var jugar = true
        while (jugar) {
            ronda += 1
            turnoJ1(tablero, ronda, jugadores)
            win = comprobarGanador(tablero, ronda, jugadores[0])
            if (win == true) {
                tablero.imprimirTablero()
                print("J1 GANA")
                break
            }

            turnoJ2(tablero, ronda, jugadores)
            win = comprobarGanador(tablero, ronda, jugadores[1])
            if (win == true) {
                tablero.imprimirTablero()
                print("J2 GANA")
                break
            }
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
    private fun elegirTipo(tipos: MutableList<String>): MutableList<String> {
        val jugadores = mutableListOf<String>()
        var elegido = false
        while (!elegido) {
            print("J1, ¿Quieres ser cara o cruz? ")
            val tipo = readln().lowercase().replaceFirstChar { it -> it.uppercase() }
            when (tipo) {
                "Cara" -> {
                    val J1 = TiposFicha.CARA.simbolo
                    val J2 = TiposFicha.CRUZ.simbolo
                    jugadores.add(J1)
                    jugadores.add(J2)
                    elegido = true
                }
                "Cruz" -> {
                    val J1 = TiposFicha.CRUZ.simbolo
                    val J2 = TiposFicha.CARA.simbolo
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
    private fun turnoJ1(tablero: Tablero, ronda:Int, jugadores: MutableList<String>): Tablero {
        var win: Boolean? = null
        val movimiento = false
        println("  --Turno J1--  ")
        while (!movimiento) {
            tablero.imprimirTablero()
            print("¿Dónde quieres colocar la ficha? ")
            val posiciones = readln().split("-")
            val ficha = Ficha(posiciones[0].toInt(), posiciones[1].toInt(), jugadores[0])
            val mov = tablero.colocarFicha(ficha)
            if (ronda == 3) win = comprobarGanador(tablero, ronda, jugadores[0])
            if (mov) break
        }
        return tablero
    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * turnoJ2 recoge el flujo de acciones que el J2 realiza en su turno
     * @param tablero -> Tablero de juego.
     * @param ronda -> Entero que representa la ronda actual
     * @param jugadores -> Lista con el tipo de ficha de J1 y J2.
     */
    private fun turnoJ2(tablero: Tablero, ronda: Int, jugadores: MutableList<String>): Tablero {
        var win: Boolean? = null
        val movimiento = false
        println("  --Turno J2--  ")
        while (!movimiento) {
            tablero.imprimirTablero()
            print("¿Dónde quieres colocar la ficha? ")
            val posiciones = readln().split("-")
            val ficha = Ficha(posiciones[0].toInt(), posiciones[1].toInt(), jugadores[1])
            val mov = tablero.colocarFicha(ficha)
            if (ronda == 3) win = comprobarGanador(tablero, ronda, jugadores[1])
            if (mov) break
        }
        return tablero
    }
    //------------------------------------------------------------------------------------------------------------------

    private fun comprobarGanador(tablero: Tablero, ronda: Int, tipo :String): Boolean? {
        var win = false
        if (ronda >= 3) {
            for (i in 1..3) {
                if (tablero.contenido[i][0] == tipo && tablero.contenido[i][1] == tipo && tablero.contenido[i][2] == tipo) {
                    win = true
                    return win
                } else if (tablero.contenido[0][i]== tipo && tablero.contenido[1][i]== tipo && tablero.contenido[2][i]== tipo) {
                    win = true
                    return win
                } else if (tablero.contenido[0][0]== tipo && tablero.contenido[1][1]== tipo && tablero.contenido[2][2]== tipo) {
                    win = true
                    return win
                } else if (tablero.contenido[0][2]== tipo && tablero.contenido[1][1] == tipo && tablero.contenido[2][0]== tipo) {
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