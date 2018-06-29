package com.github.icarohs7.unoxkcommons.extensoes

import com.github.icarohs7.unoxkcommons.estatico.BooleanMatriz
import com.github.icarohs7.unoxkcommons.estatico.DoubleMatriz
import com.github.icarohs7.unoxkcommons.estatico.IntMatriz

infix fun Boolean.preenchendoMatrizBooleanDeTamanho(dimensao: Pair<Int, Int>): BooleanMatriz {
	return BooleanMatriz(dimensao.first) { this preenchendoArrayBooleanDeTamanho dimensao.second }
}

infix fun Double.preenchendoMatrizDoubleDeTamanho(dimensao: Pair<Int, Int>): DoubleMatriz {
	return DoubleMatriz(dimensao.first) { this preenchendoArrayDoubleDeTamanho dimensao.second }
}

infix fun Int.preenchendoMatrizIntDeTamanho(dimensao: Pair<Int, Int>): IntMatriz {
	return IntMatriz(dimensao.first) { this preenchendoArrayIntDeTamanho dimensao.second }
}

infix fun Boolean.preenchendoArrayBooleanDeTamanho(dimensao: Int): BooleanArray {
	return BooleanArray(dimensao) { this }
}

infix fun Double.preenchendoArrayDoubleDeTamanho(dimensao: Int): DoubleArray {
	return DoubleArray(dimensao) { this }
}

infix fun Int.preenchendoArrayIntDeTamanho(dimensao: Int): IntArray {
	return IntArray(dimensao) { this }
}