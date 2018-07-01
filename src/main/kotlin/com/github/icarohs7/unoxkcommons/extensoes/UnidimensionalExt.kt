package com.github.icarohs7.unoxkcommons.extensoes

/**
 * Transformar elementos da lista
 */
inline infix fun <T, reified R> List<T>.transformadoPor(transformacao: (T) -> R): List<R> {
	return this.map(transformacao)
}

/**
 * Transformar elementos da lista com indice
 */
inline infix fun <T, reified R> List<T>.transformadoPorIndexed(transformacao: (index: Int, T) -> R): List<R> {
	return this.mapIndexed(transformacao)
}

/**
 * Transformar elementos do array
 */
inline infix fun <T, reified R> Array<T>.transformadoPor(transformacao: (T) -> R): Array<R> {
	return this.map(transformacao).toTypedArray()
}

/**
 * Transformar elementos do array com indice
 */
inline infix fun <T, reified R> Array<T>.transformadoPorIndexed(transformacao: (index: Int, T) -> R): Array<R> {
	return this.mapIndexed(transformacao).toTypedArray()
}