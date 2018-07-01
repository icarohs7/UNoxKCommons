# UNoxKCommons [ ![Download](https://api.bintray.com/packages/icarohs7/libraries/unoxkcommons/images/download.svg) ](https://bintray.com/icarohs7/libraries/unoxkcommons/_latestVersion)
Uma biblioteca de componentes e extensões para a linguagem Kotlin, buscando aumentar o grau<br>
de simplicidade da linguagem ao abstrair certas funções, em especial no tratamento de coleções bidimensionais.

# Sumário
* [Instalação](#instalação)
	+ [Gradle](#gradle)
	+ [Maven](#maven)
* [Funcionalidades](#funcionalidades)
	+ [Aliases](#aliases)
	+ [Coleções unidimensionais](#coleções-unidimensionais)
	+ [Coleções bidimensionais](#coleções-bidimensionais)
	+ [Extensões para Tipos Genéricos](#extensões-para-tipos-genéricos)
	
# Instalação

#### Gradle

```groovy
dependencies {
	// ...
	implementation "com.github.icarohs7:unoxkcommons:$version"
}

repositories {
	mavenCentral()
}
```

#### Maven

```xml
<dependencies>
	<!-- ... -->
	<dependency>
		<groupId>com.github.icarohs7</groupId>
		<artifactId>unoxkcommons</artifactId>
		<version>version</version>
	</dependency>
</dependencies>
```

# Funcionalidades

## Aliases
Apelidos utilizados para tipos

* `Matriz<T>` é um apelido para `Array<Array<T>>`
```kotlin
var matriz: Matriz<T>
var matriz2: Matriz<Int>
```

## Coleções unidimensionais
Funções extendendo as funcionalidades para tratamento de coleções unidimensionais,<br>
as funções funcionam para listas e arrays, ambos com 1 dimensão

* A função `transformadaPor` aplica a lambda passada para cada elemento presente na coleção
```kotlin
val lista = listOf(1,2,3)

val lTransformada = lista transformadaPor {it * it * it}    // listOf(1,8,27)
```

## Coleções bidimensionais
A biblioteca simplifica o tratamento de coleções bidimensionais adicionando diversas funções<br>
de extensão para criar e manipular esses conjuntos.<br>
As funções são exemplificadas utilizando uma lista bidimensionals,<br>
porém funcionam também utilizando matrizes.

* Cria uma matriz ou lista bidimensional preenchida com o elemento desejado atravez da sintaxe:
**valor** preenchendo**tipo**Tamanho **tamanhoDoConjunto**
```kotlin
val array = "Hello, World!" preenchendoArrayTamanho 10
val matriz = 1532 preenchendoMatrizTamanho (2 por 2)
val listaUnidimensional = 1.618 preenchendoListaTamanho 5
val listaBidimensional = 3.1415 preenchendoListaTamanho (2 por 2)
```

* Retorna a lista de células contidas na lista através da propriedade de extensão `cells`
```kotlin
val lista2d = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))

val celulas = lista2d.cells
println(celulas[0].row) // 0
println(celulas[0].col) // 0
println(celulas[0].value)   // 1
```

* A função `deepMap` aplica a lambda a cada subelemento contido na lista bidimensional e retorna a nova lista 
```kotlin
val transformada = lista2d deepMap {it * 2}   // listOf(listOf(2,4,6), listOf(8,10,12), listOf(14,16,18))
```

* A função `deepForEach` Executa a lambda passada em cada elemento, similar ao forEach, de forma profunda
```
lista2d.deepForEach { println(it) }
```

## Extensões para Tipos Genéricos
Funções de extensão podendo ser utilizadas a partir de qualquer objeto

* As funções `por` e `para` criam um par contendo os 2 elementos utilizados
```kotlin
val p = 5 por 5
val p2 = 5 para 5
```

* A função `processadoPor` aplica a lambda au elemento utilizado
```kotlin
val number = 1532 processadoPor {it - 1532} processadoPor ::println //subtrai 1532 do valor, em seguida o imprime
```
