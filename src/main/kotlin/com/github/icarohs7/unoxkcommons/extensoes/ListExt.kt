package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.tipos.NXCell

/**
 * Expande uma lista bidimensional para uma lista unidimensional contendo todos os seus elementos
 */
fun <T> List<List<T>>.expandido() = reduce { acc, linha -> acc + linha }

/**
 * Retorna a lista de células de uma lista bidimensional
 */
fun <T> List<List<T>>.cells(): List<NXCell<T>> {
	return this.foldIndexed(kotlin.collections.emptyList()) { i, acc, row ->
		acc + row.mapIndexed { j, value -> com.github.icarohs7.unoxkcommons.tipos.NXCell(i, j, value) }
	}
}

/**
 * Aplica a função de transformação a todos os elementos da lista bidimensional
 */
inline infix fun <T, reified R> List<List<T>>.transformadoRecursivamentePor(transformacao: (T) -> R) = map { it.map(transformacao) }

inline infix fun <T, reified R> List<List<T>>.transformadoRecursivamentePorIndexed(transformacao: (r: Int, c: Int, T) -> R): List<List<R>> {
	return List(this.size) { i ->
		List(this[0].size) { j ->
			transformacao(i, j, this[i][j])
		}
	}
}

/**
 * Aplica a lambda a cada elemento contido na lista bidimensional
 */
inline fun <T> List<List<T>>.deepForEach(transformacao: (T) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			this[linha][coluna] processadoPor transformacao
		}
	}
}

inline fun <T> List<List<T>>.deepForEachIndexed(transformacao: (linha: Int, coluna: Int, T) -> Unit) {
	for (linha in 0 until this.size) {
		for (coluna in 0 until this[0].size) {
			transformacao(linha, coluna, this[linha][coluna])
		}
	}
}

/**
 * Aplica a função de transformação a todos os elementos da lista
 */
inline infix fun <T, reified R> List<T>.transformadoPor(transformacao: (T) -> R) = map(transformacao)