class Juego {
    fun juego(tablero: Tablero){
        val tipos = mutableListOf<String>("Cara","Cruz")
        tablero.imprimirTablero()
        elegirTipo(tipos)
    }

    fun elegirTipo(tipos: MutableList<String>): String{
        var J1 = ""
        var elegido = false
        while (elegido == false) {
            print("¿Quieres ser cara o cruz?")
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
    fun turnoJ1(tablero: Tablero, tipos: MutableList<String>){
        print("--Turno J1--")
        tablero.imprimirTablero()
        val J1 = elegirTipo(tipos)
        print("¿Dónde quieres colocar la ficha? ")
        val posiciones = readln().split("-")
        val ficha = Ficha(posiciones[0].toInt(),posiciones[1].toInt(), J1)
    }
}