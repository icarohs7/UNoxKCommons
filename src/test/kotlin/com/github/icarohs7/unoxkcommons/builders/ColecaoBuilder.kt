package com.github.icarohs7.unoxkcommons.builders

import com.github.icarohs7.unoxkcommons.funcoes.listBidimenOf
import com.github.icarohs7.unoxkcommons.funcoes.matrizOf

fun umaMatriz() = MatrizBuilder.umaMatriz()
class MatrizBuilder private constructor() {
	companion object {
		fun umaMatriz() = MatrizBuilder()
	}
	
	private var matriz = matrizOf(2) { (it.row * 2) + it.col + 1 }
	
	fun pequena() = this.apply { matriz = matrizOf(2) { (it.row * 2) + it.col + 1 } }
	fun media() = this.apply { matriz = matrizOf(4) { (it.row * 2) + it.col + 1 } }
	fun grande() = this.apply { matriz = matrizOf(8) { (it.row * 2) + it.col + 1 } }
	
	fun agora() = matriz
}

fun umaListaBidimensional() = ListaBidimenBuilder.umaListaBidimensional()
class ListaBidimenBuilder private constructor() {
	companion object {
		fun umaListaBidimensional() = ListaBidimenBuilder()
	}
	
	private var lista = listBidimenOf(2) { (it.row * 2) + it.col + 1 }
	
	fun pequena() = this.apply { lista = listBidimenOf(2) { (it.row * 2) + it.col + 1 } }
	fun media() = this.apply { lista = listBidimenOf(4) { (it.row * 2) + it.col + 1 } }
	fun grande() = this.apply { lista = listBidimenOf(8) { (it.row * 2) + it.col + 1 } }
	
	fun agora() = lista
}