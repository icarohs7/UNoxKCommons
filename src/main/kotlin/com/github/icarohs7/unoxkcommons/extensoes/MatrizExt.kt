package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.estatico.BooleanMatriz
import com.github.icarohs7.unoxkcommons.estatico.DoubleMatriz
import com.github.icarohs7.unoxkcommons.estatico.IntMatriz
import com.github.icarohs7.unoxkcommons.estatico.Matriz
import com.github.icarohs7.unoxkcommons.tipos.NXCell

/**
 * Propriedade de extensão contendo as células da matriz
 */
val <T> Matriz<T>.cells: List<NXCell<T>>
	get() = this.foldIndexed(emptyList()) { i, acc, row -> acc + row.mapIndexed { j, value -> NXCell(i, j, value) } }

val BooleanMatriz.cells: List<NXCell<Boolean>>
	get() = this.foldIndexed(emptyList()) { i, acc, row -> acc + row.mapIndexed { j, value -> NXCell(i, j, value) } }

val IntMatriz.cells: List<NXCell<Int>>
	get() = this.foldIndexed(emptyList()) { i, acc, row -> acc + row.mapIndexed { j, value -> NXCell(i, j, value) } }

val DoubleMatriz.cells: List<NXCell<Double>>
	get() = this.foldIndexed(emptyList()) { i, acc, row -> acc + row.mapIndexed { j, value -> NXCell(i, j, value) } }

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

inline infix fun BooleanMatriz.aplicandoRecursivamente(transformacao: (Boolean) -> Boolean): BooleanMatriz {
	return BooleanMatriz(this.size) { i ->
		BooleanArray(this[0].size) { j ->
			this[i][j] processadoPor transformacao
		}
	}
}

inline infix fun BooleanMatriz.aplicandoRecursivamenteIndexed(transformacao: (r: Int, c: Int, Boolean) -> Boolean): BooleanMatriz {
	return BooleanMatriz(this.size) { i ->
		BooleanArray(this[0].size) { j ->
			transformacao(i, j, this[i][j])
		}
	}
}

inline infix fun DoubleMatriz.aplicandoRecursivamente(transformacao: (Double) -> Double): DoubleMatriz {
	return DoubleMatriz(this.size) { i ->
		DoubleArray(this[0].size) { j ->
			this[i][j] processadoPor transformacao
		}
	}
}

inline infix fun DoubleMatriz.aplicandoRecursivamenteIndexed(transformacao: (r: Int, c: Int, Double) -> Double): DoubleMatriz {
	return DoubleMatriz(this.size) { i ->
		DoubleArray(this[0].size) { j ->
			transformacao(i, j, this[i][j])
		}
	}
}

inline infix fun IntMatriz.aplicandoRecursivamente(transformacao: (Int) -> Int): IntMatriz {
	return IntMatriz(this.size) { i ->
		IntArray(this[0].size) { j ->
			this[i][j] processadoPor transformacao
		}
	}
}

inline infix fun IntMatriz.aplicandoRecursivamenteIndexed(transformacao: (r: Int, c: Int, Int) -> Int): IntMatriz {
	return IntMatriz(this.size) { i ->
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

inline fun DoubleMatriz.deepForEach(transformacao: (Double) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			this[linha][coluna] processadoPor transformacao
		}
	}
}

inline fun DoubleMatriz.deepForEachIndexed(transformacao: (linha: Int, coluna: Int, Double) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			transformacao(linha, coluna, this[linha][coluna])
		}
	}
}

inline fun IntMatriz.deepForEach(transformacao: (Int) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			this[linha][coluna] processadoPor transformacao
		}
	}
}

inline fun IntMatriz.deepForEachIndexed(transformacao: (linha: Int, coluna: Int, Int) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			transformacao(linha, coluna, this[linha][coluna])
		}
	}
}

inline fun BooleanMatriz.deepForEach(transformacao: (Boolean) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			this[linha][coluna] processadoPor transformacao
		}
	}
}

inline fun BooleanMatriz.deepForEachIndexed(transformacao: (linha: Int, coluna: Int, Boolean) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			transformacao(linha, coluna, this[linha][coluna])
		}
	}
}