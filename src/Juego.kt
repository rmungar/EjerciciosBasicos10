class Juego {
    fun juego(tablero: Tablero){
        var ronda = 1
        val ganador = false
        val tipos = mutableListOf<String>("Cara","Cruz")
        while (!ganador) {
            turnoJ1(tablero,tipos, ronda)
            turnoJ2(tablero,tipos, ronda)
            ronda += 1
        }

    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * elegirTipo se encarga unicamente de asignar Cara o Cruz a J1 en la primera ronda, puesto que J2 será el que J1 no quiera.
     * @param tipos -> Lista sencilla con "Cara" y "Cruz" dentro.
     * @return J1 -> La opción que ha seleccionado J1.
     */
    private fun elegirTipo(tipos: MutableList<String>): String{
        var J1 = ""
        var elegido = false
        while (elegido == false) {
            print("¿Quieres ser cara o cruz? ")
            val tipo = readln().lowercase().replaceFirstChar { it -> it.uppercase() }
            when (tipo) {
                "Cara" -> {
                    J1 = "Cara"
                    tipos.remove("Cara")
                    elegido = true
                }
                "Cruz" -> {
                    J1 = "Cruz"
                    tipos.remove("Cruz")
                    elegido = true
                }
                else -> {
                    println("No existe esa ficha")
                }
            }
        }
        return J1
    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * turnoJ1 recoge el flujo de acciones que el J1 realiza en su turno
     * @param tablero -> Tablero de juego.
     * @param tipos -> Lista sencilla con "Cara" y "Cruz" dentro.
     * @param ronda -> Entero que representa la ronda actual
     */
    private fun turnoJ1(tablero: Tablero, tipos: MutableList<String>, ronda:Int){
        var movimiento = false
        println("  --Turno J1--  ")
        var J1 = ""
        if (ronda == 1){
            J1 = elegirTipo(tipos)
        }
        while (!movimiento) {
            tablero.imprimirTablero()
            print("¿Dónde quieres colocar la ficha? ")
            val posiciones = readln().split("-")
            val ficha = Ficha(posiciones[0].toInt(), posiciones[1].toInt(), J1)
            movimiento = tablero.colocarFicha(ficha)
        }
        tablero.imprimirTablero()
    }
    //------------------------------------------------------------------------------------------------------------------
    /**
     * turnoJ2 recoge el flujo de acciones que el J2 realiza en su turno
     * @param tablero -> Tablero de juego.
     * @param tipos -> Lista sencilla con "Cara" y "Cruz" dentro.
     * @param ronda -> Entero que representa la ronda actual
     */
    private fun turnoJ2(tablero: Tablero, tipos: MutableList<String>, ronda: Int){
        var movimiento = false
        println("  --Turno J2--  ")
        val J2 = tipos[0]
        while (!movimiento) {
            tablero.imprimirTablero()
            print("¿Dónde quieres colocar la ficha? ")
            val posiciones = readln().split("-")
            val ficha = Ficha(posiciones[0].toInt(), posiciones[1].toInt(), J2)
            movimiento = tablero.colocarFicha(ficha)
        }
        tablero.imprimirTablero()
    }
    //------------------------------------------------------------------------------------------------------------------

    private fun comprobarGanador(tablero: Tablero, ficha: Ficha, ronda: Int) : Boolean{
        for(i in 1..3){
            return if (tablero.contenido[i][0]==tablero.contenido[i][1] && tablero.contenido[i][1]==tablero.contenido[i][2]){
                true
            } else if (tablero.contenido[0][i]==tablero.contenido[1][i] && tablero.contenido[1][i]==tablero.contenido[2][i]){
                true
            } else if (tablero.contenido[0][0]==tablero.contenido[1][1] && tablero.contenido[1][1]==tablero.contenido[2][2]){
                true
            } else if (tablero.contenido[0][2]==tablero.contenido[1][1] && tablero.contenido[1][1]==tablero.contenido[2][0]){
                true
            } else{
                false
            }
        }
        return false
    }
}