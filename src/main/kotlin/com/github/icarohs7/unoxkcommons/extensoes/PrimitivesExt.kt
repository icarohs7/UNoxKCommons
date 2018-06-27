package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.estatico.MatrizBoolean
import com.github.icarohs7.unoxkcommons.estatico.MatrizDouble
import com.github.icarohs7.unoxkcommons.estatico.MatrizInt

infix fun Boolean.preenchendoMatrizBooleanDeTamanho(dimensao: Pair<Int, Int>) = MatrizBoolean(dimensao.first) {
	this preenchendoArrayBooleanDeTamanho dimensao.second
}

infix fun Double.preenchendoMatrizDoubleDeTamanho(dimensao: Pair<Int, Int>) = MatrizDouble(dimensao.first) {
	this preenchendoArrayDoubleDeTamanho dimensao.second
}

infix fun Int.preenchendoMatrizIntDeTamanho(dimensao: Pair<Int, Int>) = MatrizInt(dimensao.first) {
	this preenchendoArrayIntDeTamanho dimensao.second
}

infix fun Boolean.preenchendoArrayBooleanDeTamanho(dimensao: Int) = BooleanArray(dimensao) { this }

infix fun Double.preenchendoArrayDoubleDeTamanho(dimensao: Int) = DoubleArray(dimensao) { this }

infix fun Int.preenchendoArrayIntDeTamanho(dimensao: Int) = IntArray(dimensao) { this }