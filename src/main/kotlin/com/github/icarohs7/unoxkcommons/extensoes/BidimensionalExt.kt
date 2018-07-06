package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.estatico.ListBidimen
import com.github.icarohs7.unoxkcommons.estatico.ListSB
import com.github.icarohs7.unoxkcommons.estatico.Matriz
import com.github.icarohs7.unoxkcommons.funcoes.listBidimenOf
import com.github.icarohs7.unoxkcommons.funcoes.matrizOf

/**
 * Transforma os elementos da lista bidimensional
 */
inline infix fun <T, reified R> ListSB<T>.deepMap(transformacao: (T) -> R): ListBidimen<R> {
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
inline infix fun <T, reified R> ListSB<T>.deepMapIndexed(transformacao: (row: Int, col: Int, T) -> R): ListBidimen<R> {
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
inline infix fun <T> ListSB<T>.deepForEach(transformacao: (T) -> Unit) {
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
inline infix fun <T> ListSB<T>.deepForEachIndexed(transformacao: (row: Int, col: Int, T) -> Unit) {
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
fun <T> ListSB<T>.deepContains(element: T): Boolean {
	return this.fold(false) { acc, row -> acc || row.contains(element) }
}

/**
 * Verifica se um elemento pertence a uma matriz
 */
fun <T> Matriz<T>.deepContains(element: T): Boolean {
	return this.fold(false) { acc, row -> acc || row.contains(element) }
}

/**
 * Realiza a cópia de uma lista bidimensional
 */
inline fun <reified T> ListSB<T>.deepCopy(): ListBidimen<T> {
	return listBidimenOf(this.size por this[0].size) { this[it.row][it.col] }
}

/**
 * Realiza a cópia de uma matriz
 */
inline fun <reified T> Matriz<T>.deepCopy(): Matriz<T> {
	return matrizOf(this.size por this[0].size) { this[it.row][it.col] }
}

/**
 * Substitui um elemento por outro na lista bidimensional e retorna a lista modificada
 */
inline fun <reified T> ListSB<T>.deepReplace(old: T, new: T): ListBidimen<T> {
	return this deepMap { if (it == old) new else it }
}

/**
 * Versão infixa da função deepReplace, aceitando um par
 */
inline infix fun <reified T> ListSB<T>.deepReplace(oldAndNew: Pair<T, T>): ListBidimen<T> {
	return this.deepReplace(oldAndNew.first, oldAndNew.second)
}

/**
 * Substitui um elemento por outro na matriz e retorna a matriz modificada
 */
inline fun <reified T> Matriz<T>.deepReplace(old: T, new: T): Matriz<T> {
	return this deepMap { if (it == old) new else it }
}

/**
 * Versão infixa da função deepReplace, aceitando um par
 */
inline infix fun <reified T> Matriz<T>.deepReplace(oldAndNew: Pair<T, T>): Matriz<T> {
	return this.deepReplace(oldAndNew.first, oldAndNew.second)
}

/**
 * Retorna a representação da lista bidimensional na forma de string
 */
fun <T> ListSB<T>.deepToString(): String {
	val sb = StringBuilder()
	this.forEach { row ->
		val rowString = buildString { row.forEach { append("$it, ") } }.dropLast(2)
		sb.append("$rowString\n")
	}
	return sb.toString().dropLast(1)
}

/**
 * Retorna a representação da matriz na forma de string
 */
fun <T> Matriz<T>.deepToString(): String {
	val sb = StringBuilder()
	this.forEach { row ->
		val rowString = buildString { row.forEach { append("$it, ") } }.dropLast(2)
		sb.append("$rowString\n")
	}
	return sb.toString().dropLast(1)
}

/**
 * Preenche todas as posições da lista bidimensional com o valor parametrizado
 */
infix fun <T> ListBidimen<T>.deepFill(value: T) {
	this.deepForEachIndexed { row, col, _ -> this[row][col] = value }
}

/**
 * Preenche todas as posições da matriz com o valor parametrizado
 */
infix fun <T> Matriz<T>.deepFill(value: T) {
	this.deepForEachIndexed { row, col, _ -> this[row][col] = value }
}