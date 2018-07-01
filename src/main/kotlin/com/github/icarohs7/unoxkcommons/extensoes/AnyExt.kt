package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.estatico.Matriz

/**
 * Função de transformação infixa, transformando um valor em outro
 * através da função passada por parâmetro
 */
inline infix fun <T, R> T.processadoPor(transformacao: (T) -> R): R {
	return transformacao(this)
}

/**
 * Função para criar uma matriz de forma declarativa.
 * Combinado com a função por, o resultado será: 5.0 preenchendoMatriz 3 por 3
 */
inline infix fun <reified T> T.preenchendoMatrizTamanho(dimensao: Pair<Int, Int>): Matriz<T> {
	return Matriz(dimensao.first) { this preenchendoArrayTamanho dimensao.second }
}

/**
 * Função para criar um array de forma declarativa.
 * Combinado com a função por, o resultado será: 20 preenchendoArrayTamanho 10
 */
inline infix fun <reified T> T.preenchendoArrayTamanho(dimensao: Int): Array<T> {
	return Array(dimensao) { this }
}

/**
 * Função para criar uma lista bidimensional de forma declarativa.
 * Combinado com a função por, o resultado será: 5.0 preenchendoListaBidimensionalDeTamanho 3 por 3
 */
inline infix fun <reified T> T.preenchendoListaTamanho(dimensao: Pair<Int, Int>): List<List<T>> {
	return List(dimensao.first) { this preenchendoListaTamanho dimensao.second }
}

/**
 * Função para criar uma lista de forma declarativa.
 * Combinado com a função por, o resultado será: 20 preenchendoListaTamanho 10
 */
inline infix fun <reified T> T.preenchendoListaTamanho(dimensao: Int): List<T> {
	return List(dimensao) { this }
}

/**
 * Criação de um par através da sintaxe A por B
 */
infix fun <A, B> A.por(that: B): Pair<A, B> {
	return Pair(this, that)
}

/**
 * Criação de um par através da sintaxe A para B
 */
infix fun <A, B> A.para(that: B): Pair<A, B> {
	return Pair(this, that)
}