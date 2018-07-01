package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.tipos.NXCell
import io.kotlintest.inspectors.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ListExtTest : StringSpec() {
	private val casos = listOf(
		(10 preenchendoListaTamanho (2 por 2) deepMap { it * 10 }) para
				(100 preenchendoListaTamanho (2 por 2)),
		
		(5.0 preenchendoListaTamanho (2 por 2) deepMap { it * 10 }) para
				(50.0 preenchendoListaTamanho (2 por 2)),
		
		(true preenchendoListaTamanho (2 por 2) deepMap { !it }) para
				(false preenchendoListaTamanho (2 por 2)),
		
		("G" preenchendoListaTamanho (2 por 2) deepMap { "${it}G" }) para
				("GG" preenchendoListaTamanho (2 por 2))
	)
	
	init {
		"Deve transformar listas bidimensionais" {
			casos.forAll { it.first shouldBe it.second }
		}
		
		"Deve transformar listas unidimensionais" {
			listOf(1, 2, 3) transformadoPor { it * it * it } shouldBe listOf(1, 8, 27)
		}
		
		"Deve processar elementos de listas bidimensionais profundamente" {
			val l = ("G-G" preenchendoListaTamanho (2 por 2)) deepMap { it.replace("-", "") }
			l.deepForEachIndexed { linha, coluna, elemento -> elemento shouldBe l[linha][coluna] }
			
			var c = 0
			l.deepForEach { c++ }
			c shouldBe l.size * l[0].size
		}
		
		"Deve retornar sua lista de células" {
			val cells = listOf(
				listOf(1, 2, 3),
				listOf(4, 5, 6),
				listOf(7, 8, 9)).cells
			val expectedCells = listOf(
				NXCell(0, 0, 1), NXCell(0, 1, 2), NXCell(0, 2, 3),
				NXCell(1, 0, 4), NXCell(1, 1, 5), NXCell(1, 2, 6),
				NXCell(2, 0, 7), NXCell(2, 1, 8), NXCell(2, 2, 9)
			)
			
			cells shouldBe expectedCells
		}
		
		"Deve converter uma lista de células em uma lista bidimensional" {
			val l2d = listOf(
				listOf(1, 2, 3),
				listOf(4, 5, 6),
				listOf(7, 8, 9)
			)
			val cells = l2d.cells
			
			cells.toList2D(0) shouldBe l2d
		}
		
		"Deve converter uma lista de células em uma matriz" {
			val matriz = arrayOf(
				arrayOf(1, 2, 3),
				arrayOf(4, 5, 6),
				arrayOf(7, 8, 9)
			)
			val cells = matriz.cells
			
			cells.toMatriz(0).contentDeepEquals(matriz) shouldBe true
		}
	}
}