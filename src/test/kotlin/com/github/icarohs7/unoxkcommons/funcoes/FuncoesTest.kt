package com.github.icarohs7.unoxkcommons.funcoes

import com.github.icarohs7.unoxkcommons.extensoes.cells
import com.github.icarohs7.unoxkcommons.extensoes.por
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class FuncoesTest : StringSpec() {
	init {
		"Deve criar matrizes" {
			matrizOf(2 por 3) { (it.row * 10) + it.col }.cells shouldBe arrayOf(arrayOf(0, 1, 2), arrayOf(10, 11, 12)).cells
		}
		
		"Deve criar listas bidimensionais" {
			listBidimenOf(2 por 3) { (it.row * 10) + it.col } shouldBe listOf(listOf(0, 1, 2), listOf(10, 11, 12))
		}
		
		"Deve criar matrizes quadradas" {
			matrizOf(2) { (it.row * 10) + it.col + 1 }.cells shouldBe arrayOf(arrayOf(1, 2), arrayOf(11, 12)).cells
		}
		
		"Deve criar listas bidimensionais quadradas" {
			listBidimenOf(2) { (it.row * 10) + it.col + 1 } shouldBe listOf(listOf(1, 2), listOf(11, 12))
		}
	}
}