package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.funcoes.listBidimenOf
import com.github.icarohs7.unoxkcommons.funcoes.matrizOf
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class BidimensionalExtTest : StringSpec() {
	private val matriz = matrizOf(2 por 3) { 2 }
	private val matrizEsperada = arrayOf(arrayOf(2, 2, 2), arrayOf(2, 2, 2))
	private val lista = listBidimenOf(2 por 3) { 2 }
	private val listaEsperada = listOf(listOf(2, 2, 2), listOf(2, 2, 2))
	
	init {
		"Deve iterar sobre os elementos de uma matriz" {
			matriz deepForEachIndexed { row, col, valor -> valor shouldBe matrizEsperada[row][col] }
			matriz deepForEachIndexed { row, col, valor -> valor shouldBe matriz[row][col] }
			
			var c = 0
			matriz deepForEach { c++ }
			c shouldBe matriz.size * matriz[0].size
		}
		
		"Deve iterar sobre os elementos de uma lista bidimensional" {
			lista deepForEachIndexed { row, col, valor -> valor shouldBe listaEsperada[row][col] }
			lista deepForEachIndexed { row, col, valor -> valor shouldBe lista[row][col] }
			
			var c = 0
			lista deepForEach { c++ }
			c shouldBe lista.size * lista[0].size
		}
		
		"Deve transformar uma matriz" {
			(matriz deepMap { it * 10 }).cells shouldBe arrayOf(arrayOf(20, 20, 20), arrayOf(20, 20, 20)).cells
			(matriz deepMapIndexed { row, col, valor -> (row * 10) + col + valor }).cells shouldBe
					arrayOf(arrayOf(2, 3, 4), arrayOf(12, 13, 14)).cells
		}
		
		"Deve transformar uma lista bidimensional" {
			lista deepMap { it * 10 } shouldBe listOf(listOf(20, 20, 20), listOf(20, 20, 20))
			lista deepMapIndexed { row, col, valor -> (row * 10) + col + valor } shouldBe listOf(listOf(2, 3, 4), listOf(12, 13, 14))
		}
		
		"Deve verificar se um elemento está contido em uma matriz" {
			val matrizModificada = matriz deepMapIndexed { row, col, valor -> (row * 10) + col + valor }
			matrizModificada.deepContains(12) shouldBe true
			matrizModificada.deepContains(13) shouldBe true
			matrizModificada.deepContains(15) shouldBe false
			matrizModificada.deepContains(5) shouldBe false
		}
		
		"Deve verificar se um elemento está contido em uma lista bidimensional" {
			val listaModificada = lista deepMapIndexed { row, col, valor -> (row * 10) + col + valor }
			listaModificada.deepContains(12) shouldBe true
			listaModificada.deepContains(13) shouldBe true
			listaModificada.deepContains(15) shouldBe false
			listaModificada.deepContains(5) shouldBe false
		}
	}
}