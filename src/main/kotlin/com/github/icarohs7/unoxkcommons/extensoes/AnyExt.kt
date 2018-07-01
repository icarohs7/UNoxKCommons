package com.github.icarohs7.unoxkcommons.extensoes

/**
 * Função de transformação infixa, transformando um valor em outro
 * através da função passada por parâmetro
 */
inline infix fun <T, R> T.processadoPor(transformacao: (T) -> R): R {
	return transformacao(this)
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