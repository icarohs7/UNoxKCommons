package com.github.icarohs7.unoxkcommons.extensoes

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AnyExtTest : StringSpec({
	"Deve processar diferentes entradas para diferentes saídas" {
		(5 processadoPor { it * it }) shouldBe 25
		
		(25 processadoPor ::listOf) shouldBe listOf(25)
	}
	
	"Deve criar coleções unidimensionais de forma idiomática" {
		(42 preenchendoArrayIntDeTamanho 2) shouldBe intArrayOf(42, 42)
		
		(2.0 preenchendoArrayDoubleDeTamanho 2) shouldBe doubleArrayOf(2.0, 2.0)
		
		(true preenchendoArrayBooleanDeTamanho 2) shouldBe booleanArrayOf(true, true)
		
		("GG" preenchendoArrayDeTamanho 2) shouldBe arrayOf("GG", "GG")
		
		("GG" preenchendoListaDeTamanho 2) shouldBe listOf("GG", "GG")
	}
	
	"Deve criar coleções bidimensionais de forma idiomática" {
		(42 preenchendoMatrizIntDeTamanho (2 por 2)).cells shouldBe Array(2) { intArrayOf(42, 42) }.cells
		
		(2.0 preenchendoMatrizDoubleDeTamanho (2 por 2)).cells shouldBe Array(2) { doubleArrayOf(2.0, 2.0) }.cells
		
		(true preenchendoMatrizBooleanDeTamanho (2 por 2)).cells shouldBe Array(2) { booleanArrayOf(true, true) }.cells
		
		("GG" preenchendoMatrizDeTamanho (2 por 2)).cells shouldBe Array(2) { arrayOf("GG", "GG") }.cells
		
		("GG" preenchendoListaDeTamanho (2 por 2)).cells shouldBe List(2) { listOf("GG", "GG") }.cells
	}
	
})