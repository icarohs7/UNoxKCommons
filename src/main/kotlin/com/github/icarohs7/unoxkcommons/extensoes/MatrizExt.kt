package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.estatico.Matriz
import com.github.icarohs7.unoxkcommons.tipos.NXCell

/**
 * Propriedade de extensão contendo as células da matriz
 */
val <T> Matriz<T>.cells: List<NXCell<T>>
	get() = this.foldIndexed(emptyList()) { i, acc, row -> acc + row.mapIndexed { j, value -> NXCell(i, j, value) } }

/**
 * Aplica uma função de transformação a cada elemento da matriz
 */
inline infix fun <T, reified R> Matriz<T>.deepMap(transformacao: (T) -> R): Matriz<R> {
	return Matriz(this.size) { row ->
		Array(this[0].size) { col ->
			transformacao(this[row][col])
		}
	}
}

inline infix fun <T, reified R> Matriz<T>.deepMapIndexed(transformacao: (row: Int, col: Int, T) -> R): Matriz<R> {
	return Matriz(this.size) { row ->
		Array(this[0].size) { col ->
			transformacao(row, col, this[row][col])
		}
	}
}

/**
 * Aplica a lambda a cada elemento contido na matriz
 */
inline infix fun <T> Matriz<T>.deepForEach(transformacao: (T) -> Unit) {
	for (row in 0 until this.size) {
		for (col in 0 until this[0].size) {
			transformacao(this[row][col])
		}
	}
}

inline infix fun <T> Matriz<T>.deepForEachIndexed(transformacao: (row: Int, col: Int, T) -> Unit) {
	for (row in 0 until this.size) {
		for (col in 0 until this[0].size) {
			transformacao(row, col, this[row][col])
		}
	}
}