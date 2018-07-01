package com.github.icarohs7.unoxkcommons.extensoes

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AnyExtTest : StringSpec() {
	val case1 = 5 preenchendoListaTamanho 2
	val case2 = 5 preenchendoArrayTamanho 2
	val case3 = 10 preenchendoListaTamanho (2 por 3)
	val case4 = 10 preenchendoMatrizTamanho (2 por 3)
	
	init {
		"Deve processar valores" {
			5 processadoPor { it * it } shouldBe 25
			25 processadoPor ::listOf shouldBe listOf(25)
			"KEK" processadoPor String::length shouldBe 3
		}
		
		"Deve criar coleções unidimensionais" {
			case1 shouldBe listOf(5, 5)
			case2 shouldBe arrayOf(5, 5)
		}
		
		"Deve criar coleções bidimensionais" {
			case3 shouldBe listOf(listOf(10, 10, 10), listOf(10, 10, 10))
			case4.cells shouldBe arrayOf(arrayOf(10, 10, 10), arrayOf(10, 10, 10)).cells
		}
	}
}