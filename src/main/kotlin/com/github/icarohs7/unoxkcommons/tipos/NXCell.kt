package com.github.icarohs7.unoxkcommons.tipos

/**
 * Tipo de uma célula de matriz, contendo linha, coluna e valor
 */
data class NXCell<T>(val row: Int, val col: Int, val value: T)