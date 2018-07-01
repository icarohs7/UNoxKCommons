package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.estatico.Matriz
import com.github.icarohs7.unoxkcommons.tipos.NXCell

/**
 * Propriedade de extensão contendo a lista de células da lista bidimensional
 */
val <T> List<List<T>>.cells: List<NXCell<T>>
	get() = this.foldIndexed(emptyList()) { i, acc, row -> acc + row.mapIndexed { j, value -> NXCell(i, j, value) } }

/**
 * Aplica a função de transformação a todos os elementos da lista
 */
inline infix fun <T, reified R> List<T>.transformadoPor(transformacao: (T) -> R): List<R> {
	return this.map(transformacao)
}

inline infix fun <T, reified R> Array<T>.transformadoPor(transformacao: (T) -> R): Array<R> {
	return this.map(transformacao).toTypedArray()
}

/**
 * Converte uma lista de células para uma matriz
 */
inline fun <reified T> List<NXCell<T>>.toMatriz(): Matriz<T?> {
	val rowNumber = this.map { it.row }.reduce(::maxOf) + 1
	val colNumber = this.map { it.col }.reduce(::maxOf) + 1
	val matriz = Matriz<T?>(rowNumber) { Array(colNumber) { null } }
	this.forEach { matriz[it.row][it.col] = it.value }
	return matriz
}

inline fun <reified T> List<NXCell<T>>.toMatriz(fallback: T): Matriz<T> {
	return this.toMatriz().deepMap { it ?: fallback }
}

/**
 * Converte uma lista de células para uma lista bidimensional
 */
inline fun <reified T> List<NXCell<T>>.toList2D(): List<MutableList<T?>> {
	val rowNumber = this.map { it.row }.reduce(::maxOf) + 1
	val colNumber = this.map { it.col }.reduce(::maxOf) + 1
	val lista = List<MutableList<T?>>(rowNumber) { MutableList(colNumber) { null } }
	this.forEach { lista[it.row][it.col] = it.value }
	return lista
}

inline fun <reified T> List<NXCell<T>>.toList2D(fallback: T): List<MutableList<T>> {
	return this.toList2D().deepMap { it ?: fallback }
}

/**
 * Aplica a função de transformação a todos os elementos da lista bidimensional
 */
inline infix fun <T, reified R> List<List<T>>.deepMap(transformacao: (T) -> R): List<MutableList<R>> {
	return this.map { it.map(transformacao).toMutableList() }
}

inline infix fun <T, reified R> List<List<T>>.deepMapIndexed(
	transformacao: (row: Int, col: Int, T) -> R): List<MutableList<R>> {
	return List(this.size) { i ->
		MutableList(this[0].size) { j ->
			transformacao(i, j, this[i][j])
		}
	}
}

/**
 * Aplica a lambda a cada elemento contido na lista bidimensional
 */
inline infix fun <T> List<List<T>>.deepForEach(transformacao: (T) -> Unit) {
	for (row in 0 until this.size) {
		for (col in 0 until this[0].size) {
			transformacao(this[row][col])
		}
	}
}

inline infix fun <T> List<List<T>>.deepForEachIndexed(transformacao: (row: Int, col: Int, T) -> Unit) {
	for (row in 0 until this.size) {
		for (col in 0 until this[0].size) {
			transformacao(row, col, this[row][col])
		}
	}
}