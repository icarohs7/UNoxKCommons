package com.github.icarohs7.unoxkcommons.extensoes

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class AnyExtTest : StringSpec() {
	init {
		"Deve processar valores" {
			5 processadoPor { it * it } shouldBe 25
			25 processadoPor ::listOf shouldBe listOf(25)
			"KEK" processadoPor String::length shouldBe 3
		}
	}
}