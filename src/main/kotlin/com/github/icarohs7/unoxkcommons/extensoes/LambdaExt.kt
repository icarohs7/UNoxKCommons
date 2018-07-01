package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.estatico.Matriz

/**
 * Preencher lista utilizando função
 */
inline infix fun <reified T> ((Int) -> T).preenchendoListaTamanho(tamanho: Int): List<T> {
	return List(tamanho) { this(it) }
}

/**
 * Preencher array utilizando função
 */
inline infix fun <reified T> ((Int) -> T).preenchendoArrayTamanho(tamanho: Int): Array<T> {
	return Array(tamanho) { this(it) }
}

/**
 * Preencher lista bidimensional utilizando função
 */
inline infix fun <reified T> ((Int, Int) -> T).preenchendoListaTamanho(tamanho: Pair<Int, Int>): List<List<T>> {
	return List(tamanho.first) { row -> List(tamanho.second) { col -> this(row, col) } }
}

/**
 * Preencher matriz utilizando função
 */
inline infix fun <reified T> ((Int, Int) -> T).preenchendoMatrizTamanho(tamanho: Pair<Int, Int>): Matriz<T> {
	return Array(tamanho.first) { row -> Array(tamanho.second) { col -> this(row, col) } }
}