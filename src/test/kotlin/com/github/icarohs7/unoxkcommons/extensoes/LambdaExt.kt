package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.funcoes.bidimen
import com.github.icarohs7.unoxkcommons.funcoes.unidimen
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class LambdaExt : StringSpec() {
	val arrayEsperado = arrayOf(2, 4, 6, 8, 10)
	val listaEsperada = listOf(2, 4, 6, 8, 10)
	val matrizEsperada = arrayOf(arrayOf(1, 2, 3), arrayOf(2, 4, 6), arrayOf(3, 6, 9))
	val lista2dEsperada = listOf(listOf(1, 2, 3), listOf(2, 4, 6), listOf(3, 6, 9))
	
	init {
		"Deve criar arrays a partir de lambdas" {
			{ col: Int -> (col + 1) * 2 } preenchendoArrayTamanho 5 shouldBe arrayEsperado
			unidimen { (it + 1) * 2 } preenchendoArrayTamanho 5 shouldBe arrayEsperado
		}
		
		"Deve criar listas a partir de lambdas" {
			{ col: Int -> (col + 1) * 2 } preenchendoListaTamanho 5 shouldBe listaEsperada
			unidimen { (it + 1) * 2 } preenchendoListaTamanho 5 shouldBe listaEsperada
		}
		
		"Deve criar matrizes a partir de lambdas" {
			({ row: Int, col: Int -> (col + 1) * (row + 1) } preenchendoMatrizTamanho (3 por 3)).cells shouldBe matrizEsperada.cells
			(bidimen { row, col -> (col + 1) * (row + 1) } preenchendoMatrizTamanho (3 por 3)).cells shouldBe matrizEsperada.cells
		}
		
		"Deve criar listas bidimensionais a partir de lambdas" {
			{ row: Int, col: Int -> (col + 1) * (row + 1) } preenchendoListaTamanho (3 por 3) shouldBe lista2dEsperada
			bidimen { row, col -> (col + 1) * (row + 1) } preenchendoListaTamanho (3 por 3) shouldBe lista2dEsperada
		}
	}
}