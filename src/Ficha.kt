class Ficha (var posx: Int, var posy: Int, var tipo: String){
    init {
        require(posx > 0) {"La fila seleccionada no está dentro del tablero"}
        require(posy > 0) {"La columna seleccionada no está dentro del tablero"}
        if (tipo == "Cara"){
            tipo = "0"
        }
        else {
            tipo = "X"
        }
    }
}