package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.builders.umaListaBidimensional
import com.github.icarohs7.unoxkcommons.builders.umaMatriz
import com.github.icarohs7.unoxkcommons.estatico.ListBidimen
import com.github.icarohs7.unoxkcommons.estatico.Matriz
import io.kotlintest.Description
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class BidimensionalExtTest : StringSpec() {
	lateinit var m: Matriz<Int>
	lateinit var l: ListBidimen<Int>
	
	override fun beforeTest(description: Description) {
		m = umaMatriz().agora()
		l = umaListaBidimensional().agora()
	}
	
	init {
		"Deve iterar sobre seus elementos" {
			m deepForEachIndexed { row, col, valor -> valor shouldBe m[row][col] }
			l deepForEachIndexed { row, col, valor -> valor shouldBe l[row][col] }
		}
		
		"Deve se transformar" {
			m.deepMap { it * 2 }.cells shouldBe arrayOf(arrayOf(2, 4), arrayOf(6, 8)).cells
			l.deepMap { it * 2 } shouldBe listOf(listOf(2, 4), listOf(6, 8))
		}
		
		"Deve verificar se possui um elemento" {
			m.deepContains(4) shouldBe true
			m.deepContains(5) shouldBe false
			l.deepContains(4) shouldBe true
			l.deepContains(5) shouldBe false
		}
		
		"Deve gerar uma cópia de si" {
			(m === umaMatriz().agora()) shouldBe false
			m.cells shouldBe umaMatriz().agora().cells
			(l === umaListaBidimensional().agora()) shouldBe false
			l shouldBe umaListaBidimensional().agora()
		}
		
		"Deve substituir seus elementos" {
			(m deepReplace (2 to 3)).cells shouldBe arrayOf(arrayOf(1, 3), arrayOf(3, 4)).cells
			(m deepReplace (2 to 3)).cells shouldBe m.deepReplace(2, 3).cells
			l deepReplace (2 to 3) shouldBe listOf(listOf(1, 3), listOf(3, 4))
			l deepReplace (2 to 3) shouldBe l.deepReplace(2, 3)
		}
		
		"Deve se transformar em String" {
			l.deepToString() shouldBe "1, 2\n3, 4"
			m.deepToString() shouldBe "1, 2\n3, 4"
		}
		
		"Deve preencher suas células com um valor" {
			m deepFill 10
			l deepFill 10
			m.cells shouldBe arrayOf(arrayOf(10, 10), arrayOf(10, 10)).cells
			l shouldBe listOf(listOf(10, 10), listOf(10, 10))
		}
	}
}