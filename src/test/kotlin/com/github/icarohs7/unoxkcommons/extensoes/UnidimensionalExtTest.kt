package com.github.icarohs7.unoxkcommons.extensoes

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class UnidimensionalExtTest : StringSpec() {
	private val case1 = listOf(1, 2, 3, 4, 5)
	private val case2 = arrayOf(1, 2, 3, 4, 5)
	private val case3 = listOf("A", "B", "C")
	
	init {
		"Deve transformar colecoes unidimensionais" {
			case1 transformadoPor { it + 4 } shouldBe listOf(5, 6, 7, 8, 9)
			case2 transformadoPor { it + 2 } shouldBe arrayOf(3, 4, 5, 6, 7)
		}
		
		"Deve transformar colecoes unidimensionais indexadas" {
			case1 transformadoPorIndexed { i, valor -> i + valor } shouldBe listOf(1, 3, 5, 7, 9)
			case2 transformadoPorIndexed { i, valor -> i + valor } shouldBe arrayOf(1, 3, 5, 7, 9)
			case3 transformadoPorIndexed { i, valor -> case3[i] shouldBe valor;valor } shouldBe listOf("A", "B", "C")
		}
	}
}