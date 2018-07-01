package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.tipos.NXCell
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ListNxCellExtTest : StringSpec() {
	val case1 = listOf(NXCell(0, 0, 5), NXCell(0, 1, 5), NXCell(1, 0, 5), NXCell(1, 1, 5))
	val case3 = 5 preenchendoListaTamanho (2 por 2)
	val case4 = 5 preenchendoMatrizTamanho (2 por 2)
	
	init {
		"Deve retornar as células de uma lista bidimensional" {
			case3.cells shouldBe case1
		}
		
		"Deve retornar as células de uma matriz" {
			case4.cells shouldBe case1
		}
	}
}