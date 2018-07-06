package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.builders.umaListaBidimensional
import com.github.icarohs7.unoxkcommons.builders.umaMatriz
import com.github.icarohs7.unoxkcommons.tipos.NXCell
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ListNxCellExtTest : StringSpec() {
	init {
		"Deve retornar as células de uma lista bidimensional" {
			umaListaBidimensional().agora().cells shouldBe listOf(NXCell(0, 0, 1), NXCell(0, 1, 2), NXCell(1, 0, 3), NXCell(1, 1, 4))
		}
		
		"Deve retornar as células de uma matriz" {
			umaMatriz().agora().cells shouldBe listOf(NXCell(0, 0, 1), NXCell(0, 1, 2), NXCell(1, 0, 3), NXCell(1, 1, 4))
		}
	}
}