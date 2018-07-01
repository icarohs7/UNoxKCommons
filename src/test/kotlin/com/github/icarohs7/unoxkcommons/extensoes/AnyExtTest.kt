package com.github.icarohs7.unoxkcommons.extensoes

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AnyExtTest : StringSpec({
	"Deve processar diferentes entradas para diferentes saídas" {
		(5 processadoPor { it * it }) shouldBe 25
		
		(25 processadoPor ::listOf) shouldBe listOf(25)
	}
	
	"Deve criar coleções unidimensionais" {
		(42 preenchendoArrayTamanho 2) shouldBe arrayOf(42, 42)
		
		(2.0 preenchendoArrayTamanho 2) shouldBe arrayOf(2.0, 2.0)
		
		(true preenchendoArrayTamanho 2) shouldBe arrayOf(true, true)
		
		("GG" preenchendoArrayTamanho 2) shouldBe arrayOf("GG", "GG")
		
		("GG" preenchendoListaTamanho 2) shouldBe listOf("GG", "GG")
	}
	
	"Deve criar coleções bidimensionais" {
		(42 preenchendoMatrizTamanho (2 por 2)).cells shouldBe Array(2) { arrayOf(42, 42) }.cells
		
		(2.0 preenchendoMatrizTamanho (2 por 2)).cells shouldBe Array(2) { arrayOf(2.0, 2.0) }.cells
		
		(true preenchendoMatrizTamanho (2 por 2)).cells shouldBe Array(2) { arrayOf(true, true) }.cells
		
		("GG" preenchendoMatrizTamanho (2 por 2)).cells shouldBe Array(2) { arrayOf("GG", "GG") }.cells
		
		("GG" preenchendoListaTamanho (2 por 2)).cells shouldBe List(2) { listOf("GG", "GG") }.cells
	}
	
})