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
		- [Criação](#criação-de-coleções-unidimensionais)
		- [Utilização](#utilização-de-coleções-unidimensionais)
	+ [Coleções bidimensionais](#coleções-bidimensionais)
		- [Criação](#criação-de-coleções-bidimensionais)
        - [Utilização](#utilização-de-coleções-bidimensionais)
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
Funções extendendo as funcionalidades para tratamento de coleções unidimensionais.<br>
As funções funcionam para listas e arrays, ambos com 1 dimensão

#### Criação de coleções unidimensionais
* Preenchendo a coleção de forma uniforme
```kotlin
val array = "Hello, World!" preenchendoArrayTamanho 10
val listaUnidimensional = 1.618 preenchendoListaTamanho 5
```

* Preenchendo a coleção de forma dinâmica
```kotlin
val conjunto1 = {linha: Int -> linha * 3} preenchendoListaTamanho 3 // listOf(0,3,6)
val conjunto2 = {linha: Int -> linha * 3} preenchendoArrayTamanho 3
val conjunto3 = unidimen {it * 3} preenchendoListaTamanho 3 // listOf(0,3,6)
val conjunto4 = unidimen {it * 3} preenchendoArrayTamanho 3
```
#### Utilização de coleções unidimensionais
* A função `transformadaPor` aplica a lambda passada para cada elemento presente na coleção
```kotlin
val lista = listOf(1,2,3)

val lTransformada = lista transformadaPor {it * it * it}    // listOf(1,8,27)
```

## Coleções bidimensionais
A biblioteca simplifica o tratamento de coleções bidimensionais adicionando diversas funções<br>
de extensão para criar e manipular esses conjuntos.<br>
As funções funcionam para ambas listas bidimensionais e matrizes.

#### Criação de coleções bidimensionais
* Preenchendo coleções de forma uniforme
```kotlin
val matriz = 1532 preenchendoMatrizTamanho (2 por 2)
val listaBidimensional = 3.1415 preenchendoListaTamanho (2 por 2)
```

* Preenchendo coleções de forma dinâmica
```kotlin
// listOf(listOf(0,1),listOf(10,11))
val conjunto1 = {linha: Int, coluna: Int-> (linha*10)+coluna} preenchendoLista2DTamanho (2 por 2)
val conjunto2 = {linha: Int, coluna: Int-> (linha*10)+coluna} matrizTamanho (2 por 2)

// listOf(listOf(0,1),listOf(10,11))
val conjunto1 = bidimen {linha, coluna-> (linha*10)+coluna} preenchendoLista2DTamanho (2 por 2)
val conjunto2 = bidimen {linha, coluna-> (linha*10)+coluna} matrizTamanho (2 por 2)
```

#### Utilização de coleções bidimensionais
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

* A função `deepForEach` executa a lambda passada em cada elemento, similar ao forEach, de forma profunda
```kotlin
lista2d.deepForEach { println(it) }
```

* A função `deepContains` verifica se um elemento esta contido em um conjunto bidimensional
```kotlin
// Criar a matriz:
// 1    2
// 11   12
val matriz = 1 preechendoMatrizTamanho (2 por 2) deepMapIndexed {row,col,value -> (row*10)+col+value}

matriz.deepContains(1)  // true
matriz.deepContains(11) // true
matriz.deepContains(3)  // false
matriz.deepContains(13) // false
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
//subtrai 1532 do valor, em seguida o imprime
val number = 1532 processadoPor {it - 1532} processadoPor ::println 
```
