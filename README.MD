# UNoxKCommons [ ![Download](https://api.bintray.com/packages/icarohs7/libraries/unoxkcommons/images/download.svg) ](https://bintray.com/icarohs7/libraries/unoxkcommons/_latestVersion)
Uma biblioteca de componentes e extensões para a linguagem Kotlin, buscando aumentar o grau<br>
de simplicidade da linguagem ao abstrair certas funções, em especial no tratamento de coleções bidimensionais.

# Sumário
* [Instalação](#instalação)
	+ [Gradle](#gradle)
	+ [Maven](#maven)
* [Funcionalidades](#funcionalidades)
	+ [Aliases](#aliases)
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

* `ListBidimen<T>` é um apelido para `List<Mutable<T>>`
```kotlin
var lista: ListBidimen<T>
var list2: ListBidimen<Int>
```

## Coleções bidimensionais
A biblioteca simplifica o tratamento de coleções bidimensionais adicionando diversas funções<br>
de extensão para criar e manipular esses conjuntos.<br>
As funções funcionam para ambas listas bidimensionais e matrizes.

#### Criação de coleções bidimensionais
* Preenchendo coleções de forma uniforme<br>
**É possível passar somente um valor para tamanho quando a coleção tem dimensões iguais**
```kotlin
val listaBidimensional = listBidimenOf(2 por 2) {3.1415} 
val matriz = matrizOf(2 por 2) {1532} 
```

* Preenchendo coleções de forma dinâmica
```kotlin
// listOf(listOf(0,1),listOf(10,11))
val conjunto1 = listBidimenOf(2 por 2) {(it.row*10)+it.col}
val conjunto2 = matrizOf(2 por 2) {(it.row*10)+it.col}
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
lista2d deepForEach { println(it) }
```

* A função `deepContains` verifica se um elemento esta contido em um conjunto bidimensional
```kotlin
// Criar a matriz:
// 1    2
// 11   12
val matriz = matrizOf(2 por 2){(it.row*10)+it.col+1} 

matriz.deepContains(1)  // true
matriz.deepContains(11) // true
matriz.deepContains(3)  // false
matriz.deepContains(13) // false
``` 

* A função `deepCopy` cria uma nova instância da coleção contendo os mesmos elementos da coleção copiada
```kotlin
val matriz = arrayOf(arrayOf(1,2),arrayOf(3,4))
val novaMatriz = matriz.deepCopy()
val identicas = (matriz === novaMatriz) // false -> referências diferentes
val iguais = (matriz.cells == novaMatriz.cells) // true -> conteúdos iguais
```

* A função `deepReplace` retorna uma nova coleção onde todos os elementos desejados são substituidos por outros
```kotlin
val listaAntiga = listOf(listOf(1,2),listOf(2,3))
val listaNova = listaAntiga.deepReplace(2,42) // Substitui todas as ocorrências do valor 2 pelo valor 42
println(listaNova) // listOf(listOf(1,42),listOf(42,3))
```

* A função `deepToString` retorna a representação em String da coleção bidimensional
```kotlin
val matriz = matrizOf(2) { (it.row*2) + it.col }

// Será impresso:
// 0, 1
// 2, 3
println(matriz.deepToString)
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
