package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.estatico.Matriz

/**
 * Transforma os elementos da lista bidimensional
 */
inline infix fun <T, reified R> List<List<T>>.deepMap(transformacao: (T) -> R): List<MutableList<R>> {
	return this.map { it.map(transformacao).toMutableList() }
}

/**
 * Transforma os elementos da matriz
 */
inline infix fun <T, reified R> Matriz<T>.deepMap(transformacao: (T) -> R): Matriz<R> {
	return Matriz(this.size) { row ->
		kotlin.Array(this[0].size) { col ->
			transformacao(this[row][col])
		}
	}
}

/**
 * Transforma os elementos da lista bidimensional com índice
 */
inline infix fun <T, reified R> List<List<T>>.deepMapIndexed(
	transformacao: (row: Int, col: Int, T) -> R): List<MutableList<R>> {
	return List(this.size) { i ->
		MutableList(this[0].size) { j ->
			transformacao(i, j, this[i][j])
		}
	}
}

/**
 * Transforma os elementos da matriz com índice
 */
inline infix fun <T, reified R> Matriz<T>.deepMapIndexed(transformacao: (row: Int, col: Int, T) -> R): Matriz<R> {
	return Matriz(this.size) { row ->
		kotlin.Array(this[0].size) { col ->
			transformacao(row, col, this[row][col])
		}
	}
}

/**
 * Processa os elementos da lista bidimensional sem modificá-los
 */
inline infix fun <T> List<List<T>>.deepForEach(transformacao: (T) -> Unit) {
	for (row in 0 until this.size) {
		for (col in 0 until this[0].size) {
			transformacao(this[row][col])
		}
	}
}

/**
 * Processa os elementos da matriz sem modificá-los
 */
inline infix fun <T> Matriz<T>.deepForEach(transformacao: (T) -> Unit) {
	for (row in 0 until this.size) {
		for (col in 0 until this[0].size) {
			transformacao(this[row][col])
		}
	}
}

/**
 * Processa os elementos da lista bidimensional sem modificá-los com índice
 */
inline infix fun <T> List<List<T>>.deepForEachIndexed(transformacao: (row: Int, col: Int, T) -> Unit) {
	for (row in 0 until this.size) {
		for (col in 0 until this[0].size) {
			transformacao(row, col, this[row][col])
		}
	}
}

/**
 * Processa os elementos da matriz sem modificá-los com índice
 */
inline infix fun <T> Matriz<T>.deepForEachIndexed(transformacao: (row: Int, col: Int, T) -> Unit) {
	for (row in 0 until this.size) {
		for (col in 0 until this[0].size) {
			transformacao(row, col, this[row][col])
		}
	}
}

/**
 * Verifica se um elemento pertence a uma matriz
 */
fun <T> List<List<T>>.deepContains(element: T): Boolean {
	return this.fold(false) { acc, row -> acc || row.contains(element) }
}

/**
 * Verifica se um elemento pertence a uma matriz
 */
fun <T> Matriz<T>.deepContains(element: T): Boolean {
	return this.fold(false) { acc, row -> acc || row.contains(element) }
}