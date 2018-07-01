package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.estatico.Matriz
import com.github.icarohs7.unoxkcommons.tipos.NXCell

/**
 * Propriedade de extensão contendo as células da matriz
 */
val <T> Matriz<T>.cells: List<NXCell<T>>
	get() = this.foldIndexed(emptyList()) { i, acc, row -> acc + row.mapIndexed { j, value -> NXCell(i, j, value) } }

/**
 * Propriedade de extensão contendo a lista de células da lista bidimensional
 */
val <T> List<List<T>>.cells: List<NXCell<T>>
	get() = this.foldIndexed(emptyList()) { i, acc, row -> acc + row.mapIndexed { j, value -> NXCell(i, j, value) } }

/**
 * Converter para matriz, preenchendo os valores não informados por nulo
 */
inline fun <reified T> List<NXCell<T>>.toMatriz(): Matriz<T?> {
	val rowNumber = this.map { it.row }.reduce(::maxOf) + 1
	val colNumber = this.map { it.col }.reduce(::maxOf) + 1
	val matriz = Matriz<T?>(rowNumber) { Array(colNumber) { null } }
	this.forEach { matriz[it.row][it.col] = it.value }
	return matriz
}

/**
 * Converter para matriz, preenchendo os valores não informados pelo valor parametrizado
 */
inline fun <reified T> List<NXCell<T>>.toMatriz(fallback: T): Matriz<T> {
	return this.toMatriz().deepMap { it ?: fallback }
}

/**
 * Converter para lista bidimensional, preenchendo os valores não informados por nulo
 */
inline fun <reified T> List<NXCell<T>>.toList2D(): List<MutableList<T?>> {
	val rowNumber = this.map { it.row }.reduce(::maxOf) + 1
	val colNumber = this.map { it.col }.reduce(::maxOf) + 1
	val lista = List<MutableList<T?>>(rowNumber) { MutableList(colNumber) { null } }
	this.forEach { lista[it.row][it.col] = it.value }
	return lista
}

/**
 * Converter para lista bidimensional, preenchendo os valores não informados pelo valor parametrizado
 */
inline fun <reified T> List<NXCell<T>>.toList2D(fallback: T): List<MutableList<T>> {
	return this.toList2D().deepMap { it ?: fallback }
}