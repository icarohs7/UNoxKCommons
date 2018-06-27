# UNoxKCommons [ ![Download](https://api.bintray.com/packages/icarohs7/libraries/unoxkcommons/images/download.svg) ](https://bintray.com/icarohs7/libraries/unoxkcommons/_latestVersion)
Uma biblioteca de componentes e extensões para a linguagem
Kotlin, buscando aumentar o grau de simplicidade da linguagem
ao abstrair certas funções.

# Sumário
* [Dependências](#dependências)
  + [Gradle](#gradle)
  + [Maven](#maven)
* [Aliases](#aliases)
* [Extensões](#extensões)
	+ [Listas](#listas)
		- [Listas Bidimensionais](#listas-bidimensionais)
	+ [Tipos Primitivos](#tipos-primitivos)
	+ [Matrizes](#matrizes)
	+ [Tipos Genéricos](#tipos-genéricos)
## Dependências

#### Gradle

```groovy
dependencies {
	// ...
	implementation 'com.github.icarohs7:unoxkcommons:<version>'
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
## Aliases
Apelidos utilizados para tipos

```kotlin
// Apelido para Array<Array<T>>
var m: Matriz<T>

// Apelido para Array<IntArray>
var m2: MatrizInteira

// Apelido para Array<DoubleArray>
var m3: MatrizDouble

// Apelido para Array<BooleanArray>
var m4: MatrizBooleana
```

## Extensões
Funções adicionando funcionalidades a classes existentes

### Listas
Funções de extensão em listas
```kotlin
val lista = listOf(1,2,3)

/* A função transformadaPor aplica a lambda passada para cada
 * elemento presente na lista */
val lTransformada = lista transformadaPor {it * it * it}    // listOf(1,8,27)
```

#### Listas Bidimensionais
Funções de extensão em listas bidimensionais
```kotlin
val lista2d = listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))

/* A função expandido converte uma lista bidimensional em unidimensional
 * concatenando todas as linhas da lista em outra contendo os elementos */
val unificada = lista2d.expandido() // listOf(1,2,3,4,5,6,7,8,9)

/* A função transformadoRecursivamentePor aplica a lambda a cada subelemento
 * contido na lista bidimensional */
val transformada = lista2d transformadoRecursivamentePor {it * 2}   // listOf(listOf(2,4,6), listOf(8,10,12), listOf(14,16,18))

/* Executa a lambda passada em cada elemento, similar ao forEach, de forma profunda */
lista2d.deepForEach { println(it) }
```

### Tipos Primitivos
Funções de extensão para tipos primitivos da linguagem
```kotlin
/* Cria uma matriz de valores double de tamanho 2 por 2 com o valor 3.5 em cada elemento */
val m = 3.5 preenchendoMatrizDoubleDeTamanho (2 por 2)

val a = 3.5 preenchendoArrayDoubleDeTamanho 2

/* Cria uma matriz de valores inteira de tamanho 2 por 2 com o valor 1532 em cada elemento */
val m2 = 1532 preenchendoMatrizIntDeTamanho (2 por 2)

val a2 = 1532 preenchendoArrayIntDeTamanho 2

/* Cria uma matriz de valores booleanos de tamanho 2 por 2 com o valor true em cada elemento */
val m3 = true preenchendoMatrizBooleanDeTamanho (2 por 2)

val a3 = true preenchendoArrayBooleanDeTamanho 2
```

### Matrizes
Funções de extensão para arrays bidimensionais (matrizes)
```kotlin
val m = 1532 preenchendoMatrizIntDeTamanho (2 por 2)

/* Aplica a lambda passada a cada subelemento da matriz,
 * Em matrizes genéricas a função correspondente chama-se transformadoRecursivamentePor */
val m2 = m aplicandoRecursivamente {it / 2}

/* Executa a lambda passada em cada elemento, similar ao forEach, de forma profunda */
m.deepForEach { println(it) }
```

### Tipos Genéricos
Funções de extensão podendo ser utilizadas a partir de qualquer objeto
```kotlin
/* Cria um par contendo os 2 elementos utilizados */
val p = 5 por 5
val p2 = 5 para 5

/* Cria uma lista de tamanho 5 onde cada posição contém o elemento "GG" */
val l = "GG" preenchendoListaDeTamanho 5
val l2 = "GG" preenchendoListaDeTamanho (2 por 2)   // Também utilizado em listas bidimensionais

/* Cria uma matriz de tamanho 3 por 3 preenchida com a data atual */
val d = Date() preenchendoMatrizDeTamanho (3 por 3)

/* Aplica a lambda ao elemento, podendo ser encadeado */
val number = 1532 processadoPor {it - 1532} processadoPor ::println
```