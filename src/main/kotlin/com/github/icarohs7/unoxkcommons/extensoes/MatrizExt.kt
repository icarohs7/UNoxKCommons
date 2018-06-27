package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.estatico.Matriz
import com.github.icarohs7.unoxkcommons.estatico.MatrizBoolean
import com.github.icarohs7.unoxkcommons.estatico.MatrizDouble
import com.github.icarohs7.unoxkcommons.estatico.MatrizInt

/**
 * Expande uma matriz para um array contendo todos os seus elementos
 */
fun <T> Matriz<T>.expandido() = reduce { acc, linha -> acc + linha }

fun MatrizBoolean.expandido() = reduce { acc, linha -> acc + linha }
fun MatrizDouble.expandido() = reduce { acc, linha -> acc + linha }
fun MatrizInt.expandido() = reduce { acc, linha -> acc + linha }

/**
 * Aplica uma função de transformação a cada elemento da matriz
 */
inline infix fun <T, reified R> Matriz<T>.transformadoRecursivamentePor(transformacao: (T) -> R): Matriz<R> {
	return Matriz(this.size) { i ->
		Array(this[0].size) { j ->
			this[i][j] processadoPor transformacao
		}
	}
}

inline infix fun <T, reified R> Matriz<T>.transformadoRecursivamenteIndexedPor(transformacao: (r: Int, c: Int, T) -> R): Matriz<R> {
	return Matriz(this.size) { i ->
		Array(this[0].size) { j ->
			transformacao(i, j, this[i][j])
		}
	}
}

inline infix fun MatrizBoolean.aplicandoRecursivamente(transformacao: (Boolean) -> Boolean): MatrizBoolean {
	return MatrizBoolean(this.size) { i ->
		BooleanArray(this[0].size) { j ->
			this[i][j] processadoPor transformacao
		}
	}
}

inline infix fun MatrizBoolean.aplicandoRecursivamenteIndexed(transformacao: (r: Int, c: Int, Boolean) -> Boolean): MatrizBoolean {
	return MatrizBoolean(this.size) { i ->
		BooleanArray(this[0].size) { j ->
			transformacao(i, j, this[i][j])
		}
	}
}

inline infix fun MatrizDouble.aplicandoRecursivamente(transformacao: (Double) -> Double): MatrizDouble {
	return MatrizDouble(this.size) { i ->
		DoubleArray(this[0].size) { j ->
			this[i][j] processadoPor transformacao
		}
	}
}

inline infix fun MatrizDouble.aplicandoRecursivamenteIndexed(transformacao: (r: Int, c: Int, Double) -> Double): MatrizDouble {
	return MatrizDouble(this.size) { i ->
		DoubleArray(this[0].size) { j ->
			transformacao(i, j, this[i][j])
		}
	}
}

inline infix fun MatrizInt.aplicandoRecursivamente(transformacao: (Int) -> Int): MatrizInt {
	return MatrizInt(this.size) { i ->
		IntArray(this[0].size) { j ->
			this[i][j] processadoPor transformacao
		}
	}
}

inline infix fun MatrizInt.aplicandoRecursivamenteIndexed(transformacao: (r: Int, c: Int, Int) -> Int): MatrizInt {
	return MatrizInt(this.size) { i ->
		IntArray(this[0].size) { j ->
			transformacao(i, j, this[i][j])
		}
	}
}

/**
 * Aplica a lambda a cada elemento contido na matriz
 */
inline fun <T> Matriz<T>.deepForEach(transformacao: (T) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			this[linha][coluna] processadoPor transformacao
		}
	}
}

inline fun <T> Matriz<T>.deepForEachIndexed(transformacao: (linha: Int, coluna: Int, T) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			transformacao(linha, coluna, this[linha][coluna])
		}
	}
}

inline fun MatrizDouble.deepForEach(transformacao: (Double) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			this[linha][coluna] processadoPor transformacao
		}
	}
}

inline fun MatrizDouble.deepForEachIndexed(transformacao: (linha: Int, coluna: Int, Double) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			transformacao(linha, coluna, this[linha][coluna])
		}
	}
}

inline fun MatrizInt.deepForEach(transformacao: (Int) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			this[linha][coluna] processadoPor transformacao
		}
	}
}

inline fun MatrizInt.deepForEachIndexed(transformacao: (linha: Int, coluna: Int, Int) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			transformacao(linha, coluna, this[linha][coluna])
		}
	}
}

inline fun MatrizBoolean.deepForEach(transformacao: (Boolean) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			this[linha][coluna] processadoPor transformacao
		}
	}
}

inline fun MatrizBoolean.deepForEachIndexed(transformacao: (linha: Int, coluna: Int, Boolean) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			transformacao(linha, coluna, this[linha][coluna])
		}
	}
}