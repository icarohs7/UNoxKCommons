package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.tipos.NXCell
import io.kotlintest.inspectors.forAll
import io.kotlintest.matchers.boolean.shouldBeTrue
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class MatrizExtTest : StringSpec() {
	private val casosTransformacao = listOf(
		(10 preenchendoMatrizTamanho (2 por 2) deepMap { it * 10 }) para
				(100 preenchendoMatrizTamanho (2 por 2)),
		
		(5.0 preenchendoMatrizTamanho (2 por 2) deepMap { it * 10 }) para
				(50.0 preenchendoMatrizTamanho (2 por 2)),
		
		(true preenchendoMatrizTamanho (2 por 2) deepMap { !it }) para
				(false preenchendoMatrizTamanho (2 por 2)),
		
		("G" preenchendoMatrizTamanho (2 por 2) deepMap { "${it}G" }) para
				("GG" preenchendoMatrizTamanho (2 por 2))
	)
	
	init {
		"Deve transformar matrizes" {
			casosTransformacao.forAll { it.first.contentDeepEquals(it.second).shouldBeTrue() }
		}
		
		"Deve processar elementos de matrizes inteiras profundamente" {
			val m = (0 preenchendoMatrizTamanho (2 por 2)) deepMap { it * it }
			m.deepForEachIndexed { linha, coluna, elemento -> elemento shouldBe m[linha][coluna] }
			
			var c = 0
			m.deepForEach { c++ }
			c shouldBe m.size * m[0].size
		}
		
		"Deve processar elementos de matrizes double profundamente" {
			val m2 = (1.532 preenchendoMatrizTamanho (2 por 2)) deepMap { it * it }
			m2.deepForEachIndexed { linha, coluna, elemento -> elemento shouldBe m2[linha][coluna] }
			
			var c = 0
			m2.deepForEach { c++ }
			c shouldBe m2.size * m2[0].size
		}
		
		"Deve processar elementos de matrizes booleanas profundamente" {
			val m3 = (true preenchendoMatrizTamanho (2 por 2)) deepMap { !it }
			m3.deepForEachIndexed { linha, coluna, elemento -> elemento shouldBe m3[linha][coluna] }
			
			var c = 0
			m3.deepForEach { c++ }
			c shouldBe m3.size * m3[0].size
		}
		
		"Deve processar elementos de matrizes genéricas profundamente" {
			val m4 = ("G-G" preenchendoMatrizTamanho (2 por 2)) deepMap { it.replace("-", "") }
			m4.deepForEachIndexed { linha, coluna, elemento -> elemento shouldBe m4[linha][coluna] }
			
			var c = 0
			m4.deepForEach { c++ }
			c shouldBe m4.size * m4[0].size
		}
		
		"Deve retornar sua lista de células" {
			val cells = arrayOf(
				arrayOf(1, 2, 3),
				arrayOf(4, 5, 6),
				arrayOf(7, 8, 9)).cells
			val expectedCells = listOf(
				NXCell(0, 0, 1), NXCell(0, 1, 2), NXCell(0, 2, 3),
				NXCell(1, 0, 4), NXCell(1, 1, 5), NXCell(1, 2, 6),
				NXCell(2, 0, 7), NXCell(2, 1, 8), NXCell(2, 2, 9)
			)
			
			cells shouldBe expectedCells
		}
	}
	
}