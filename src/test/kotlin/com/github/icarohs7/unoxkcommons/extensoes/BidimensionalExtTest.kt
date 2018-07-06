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
		
		"Deve copiar uma lista bidimensional" {
			val listaOriginal = listBidimenOf(5) { (it.row * 10) + it.col }
			val listaCopia = listaOriginal.deepCopy()
			listaOriginal.forEachIndexed { index, _ ->
				listaCopia[index] shouldBe listaOriginal[index]
				(listaCopia[index] === listaOriginal[index]) shouldBe false
			}
			(listaOriginal === listaCopia) shouldBe false
		}
		
		"Deve copiar uma matriz" {
			val matrizOriginal = matrizOf(5) { (it.row * 10) + it.col }
			val matrizCopia = matrizOriginal.deepCopy()
			matrizOriginal.forEachIndexed { index, _ ->
				matrizCopia[index] shouldBe matrizOriginal[index]
				(matrizCopia[index] === matrizOriginal[index]) shouldBe false
			}
			(matrizOriginal === matrizCopia) shouldBe false
		}
		
		"Deve substituir elementos de um conjunto bidimensional" {
			val matrizAntiga = arrayOf(arrayOf(1, 2), arrayOf(2, 3))
			val matrizNova = matrizAntiga.deepReplace(2, 1532)
			
			val listaAntiga = listOf(listOf(1, 2), listOf(2, 3))
			val listaNova = listaAntiga.deepReplace(2, 1532)
			
			listaNova shouldBe listOf(listOf(1, 1532), listOf(1532, 3))
			matrizNova.cells shouldBe listaNova.cells
		}
		
		"Deve converter um conjunto bidimensional para string" {
			val lista = listBidimenOf(2) { (it.row * 2) + it.col }
			val matriz = matrizOf(2) { (it.row * 2) + it.col }
			
			val listaString = lista.deepToString()
			listaString shouldBe "0, 1\n2, 3"
			matriz.deepToString() shouldBe listaString
		}
	}
}