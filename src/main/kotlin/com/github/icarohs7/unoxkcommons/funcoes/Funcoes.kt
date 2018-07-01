package com.github.icarohs7.unoxkcommons.funcoes

import com.github.icarohs7.unoxkcommons.estatico.ListBidimen
import com.github.icarohs7.unoxkcommons.estatico.Matriz
import com.github.icarohs7.unoxkcommons.tipos.Coordinate2D

/**
 * Função auxiliar para criação de matrizes bidimensionais
 */
inline fun <reified T> matrizOf(size: Pair<Int, Int>, init: (coords: Coordinate2D) -> T): Matriz<T> {
	return Matriz(size.first) { row -> Array(size.second) { col -> init(Coordinate2D(row, col)) } }
}

/**
 * Função auxiliar para criação de matrizes bidimensionais quadrados
 */
inline fun <reified T> matrizOf(size: Int, init: (coords: Coordinate2D) -> T): Matriz<T> {
	return Matriz(size) { row -> Array(size) { col -> init(Coordinate2D(row, col)) } }
}

/**
 * Função auxiliar para criação de listas bidimensionais
 */
inline fun <reified T> listBidimenOf(size: Pair<Int, Int>, init: (coords: Coordinate2D) -> T): ListBidimen<T> {
	return List(size.first) { row -> MutableList(size.second) { col -> init(Coordinate2D(row, col)) } }
}

/**
 * Função auxiliar para criação de listas bidimensionais quadradas
 */
inline fun <reified T> listBidimenOf(size: Int, init: (coords: Coordinate2D) -> T): ListBidimen<T> {
	return List(size) { row -> MutableList(size) { col -> init(Coordinate2D(row, col)) } }
}