# UNoxKCommons
Uma biblioteca de componentes e extensões para a linguagem
Kotlin, buscando aumentar o grau de simplicidade da linguagem
ao abstrair certas funções.

# Sumário
* [Aliases](#aliases)
* [Extensões](#extensões)
	+ [List](#listas)
		- [List`<List>`](#listas-bidimensionais)

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
```