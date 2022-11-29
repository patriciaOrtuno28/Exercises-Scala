//  ___  ___   _   _      _   
// / __|/ __| /_\ | |    /_\  
// \__ \ (__ / _ \| |__ / _ \ 
// |___/\___/_/ \_\____/_/ \_\
                            
//--------- EJERCICIO 1 ---------//
// Función
def firstp (obj: Any, lst: List[Any]): Boolean = {
  if (obj == lst.head) true else false
}

// Uso
println("/--------- EJERCICIO 1 ---------/")
val ej1_obj1: Char = 'a'
val ej1_lst1: List[Char] = List('a', 'b', 'c')
println("Función: firstp('a', List('a', 'b', 'c'))")
println("Resultado esperado: " + true)
println("Resultado obtenido: " + firstp(ej1_obj1, ej1_lst1))
val ej1_obj2: Int = 2
val ej1_lst2: List[Int] = List(4, 6, 2)
println("Función: firstp(2, List(4, 6, 2))")
println("Resultado esperado: " + false)
println("Resultado obtenido: " + firstp(ej1_obj2, ej1_lst2))


//--------- EJERCICIO 2 ---------//
// Función
// Versión menos eficiente
/*def duplicar (lst: List[Any]): List[List[Any]] = {
  var result = List[List[Any]]()
  for (l <- lst.reverse) {
    val auxLst: List[Any] = List(l, l)
    result = auxLst :: result
  }
  result
}*/
// Versión más eficiente
def duplicar(lst: List[Any]): List[List[Any]] = lst match {
  case l :: lsr => {
    List(l, l) :: duplicar(lsr)
  }
  case Nil => Nil
}

// Uso
println("/--------- EJERCICIO 2 ---------/")
val ej2_lst_original: List[Int] = List(1, 2, 3)
val ej2_lst_final: List[List[Any]] = duplicar(ej2_lst_original)
println("Función: duplicar(List(1, 2, 3))")
println("Resultado obtenido [Int]: " + ej2_lst_final)
val ej2_lst_original2: List[Char] = List('a', 'b', 'c')
val ej2_lst_final2: List[List[Any]] = duplicar(ej2_lst_original2)
println("Función: duplicar(List('a', 'b', 'c'))")
println("Resultado obtenido [Char]: " + ej2_lst_final2)


//--------- EJERCICIO 3 ---------//
// Función
def countdown (N: Int): List[Int] = {
  if (N <= 0) {
    Nil
  }
  else {
    N :: countdown(N - 1)
  }
}

// Uso
println("/--------- EJERCICIO 3 ---------/")
val ej3_N: Int = 10
val ej3_lst: List[Int] = countdown(ej3_N)
println("Función: countdown(10)")
println("Resultado obtenido: " + ej3_lst)


//--------- EJERCICIO 4 ---------//
// Función
// Opción sencilla:   def reverse (lst: List[Any]): List[Any] = lst.reverse
// Opción recursiva:
def reverse (lst: List[Any]): List[Any] = {
  if (lst.size == 1) {
       List(lst.head)
  }
  else {
    reverse(lst.tail) ::: List(lst.head)
  }
}

// Uso
println("/--------- EJERCICIO 4 ---------/")
val ej4_lst_original: List[Int] = List(1, 2, 3)
val ej4_lst_final: List[Any] = reverse(ej4_lst_original)
println("Función: reverse(List(1, 2, 3))")
println("Resultado obtenido: " + ej4_lst_final)


//--------- EJERCICIO 5 ---------//
// Función
def substitute (x: Any, y: Any, ls: List[Any]): List[Any] = ls match {
  case l :: lsr => { // l -> elemento actual / lsr -> resto de la lista
    if (l == y) x :: substitute(x, y, lsr)
    else l :: substitute(x, y, lsr)
  }
  case Nil => Nil
}

// Uso
println("/--------- EJERCICIO 5 ---------/")
val ej5_x: Char = 'x'
val ej5_y: Char = 'y'
val ej5_lst_original: List[Char] = List('a', 'y', 'x', 'b', 'c', 'y')
val ej5_lst_final: List[Any] = substitute(ej5_x, ej5_y, ej5_lst_original)
println("Función: substitute('x', 'y', List('a', 'y', 'x', 'b', 'c', 'y'))")
println("Resultado obtenido: " + ej5_lst_final)


//--------- EJERCICIO 6 ---------//
// Función
def setequal (lst1: List[Any], lst2: List[Any]): Boolean = {
  (lst1.filter(l1 => !lst2.contains(l1)) == Nil) && (lst2.filter(l2 => !lst1.contains(l2)) == Nil)
}

// Uso
println("/--------- EJERCICIO 6 ---------/")
val ej6_lst1: List[Int] = List(1, 2, 3)
val ej6_lst2: List[Int] = List(2, 3, 1)
val ej6_bool: Boolean = setequal(ej6_lst1, ej6_lst2)
println("Función: setequal(List(1, 2, 3), List(2, 3, 1))")
println("Resultado obtenido: " + ej6_bool)
val ej6_lst1_2: List[Int] = List(1, 2, 3)
val ej6_lst2_2: List[Int] = List(2, 3, 1, 5)
val ej6_bool_2: Boolean = setequal(ej6_lst1_2, ej6_lst2_2)
println("Función: setequal(List(1, 2, 3), List(2, 3, 1, 5))")
println("Resultado obtenido: " + ej6_bool_2)


//--------- EJERCICIO 7 ---------//
// Función
// Versión menos eficiente
/* def impares (lst: List[Any]): List[Any] = {
  var result: List[Any] = List[Any]()
  val oddIndxs: IndexedSeq[Int] = lst.indices.filter(i => i%2 != 0)
  for (o <- oddIndxs) { result = lst(o - 1) :: result }
  result.reverse
} */
// Versión más eficiente
def impares (lst: List[Any]): List[Any] = lst match {
  case l :: lsr => {
    l :: impares(lsr.tail)
  }
  case Nil => Nil
}

// Uso
println("/--------- EJERCICIO 7 ---------/")
val ej7_lst_original: List[Char] = List('a', 'b', 'c', 'd', 'e', 'f')
val ej7_lst_final: List[Any] = impares(ej7_lst_original)
println("Función: impares(List('a', 'b', 'c', 'd', 'e', 'f'))")
println("Resultado obtenido: " + ej7_lst_final)

//--------- EJERCICIO 8 ---------//
// Función
// Find the last element of a list.
def last (lst: List[Any]): Any = lst match {
  case l :: Nil => l
  case l :: lsr => last (lsr)
  case Nil => Nil
}

// Uso
println("/--------- EJERCICIO 8 ---------/")
println("Función: last(List(1, 1, 2, 3, 5, 8))")
println("Resultado obtenido: " + last(List(1, 1, 2, 3, 5, 8)))

//--------- EJERCICIO 9 ---------//
// Función
// Find the last but one element of a list
def penultimate(lst: List[Any]): Any = lst match {
  case Nil => Nil
  case x :: Nil => Nil
  case x :: y :: Nil => x
  case x :: y :: lsr => penultimate (lsr)
  case _ => Nil
}

// Uso
println("/--------- EJERCICIO 9 ---------/")
println("Función: penultimate(List(1, 1, 2, 3, 5, 8))")
println("Resultado obtenido: " + penultimate(List(1, 1, 2, 3, 5, 8)))
println("Función: penultimate(List())")
println("Resultado obtenido: " + penultimate(List()))
println("Función: penultimate(List(1))")
println("Resultado obtenido: " + penultimate(List(1)))
println("Función: penultimate(List(1, 2))")
println("Resultado obtenido: " + penultimate(List(1, 2)))

//--------- EJERCICIO 10 ---------//
// Función
// Find the Kth element of a list.
def nth(n: Int, lst: List[Any]): Any = (n, lst) match {
  case (n, Nil) => Nil
  case (0, l :: _) => l
  case (n, l :: lsr) => nth(n - 1, lsr)
}

// Uso
println("/--------- EJERCICIO 10 ---------/")
println("Función: nth(4, List(1, 1, 2, 3, 5, 8))")
println("Resultado obtenido: " + nth(4, List(1, 1, 2, 3, 5, 8)))

//--------- EJERCICIO 11 ---------//
// Función
// Find is a List has elements that form a Palindrome
def isPalindrome (lst: List[Any]): Boolean = lst match {
  case Nil => true
  case l :: Nil => true
  case a +: w :+ b if(a == b) => isPalindrome(w)
  case _ => false
}

// Uso
println("/--------- EJERCICIO 11 ---------/")
println("Función: isPalindrome(List(5, 4, 3, 2, 2, 3, 4, 5))")
println("Resultado obtenido: " + isPalindrome(List(5, 4, 3, 2, 2, 3, 4, 5)))

//--------- EJERCICIO 12 ---------//
// Función
// Drop consecutive elements in a list
def simplifica (lst: List[Any]): List[Any] = lst match {
  case Nil => Nil
  case l :: lsr => l :: simplifica(lsr.dropWhile(_ == l))
}

// Uso
println("/--------- EJERCICIO 11 ---------/")
println("Función: simplifica(List(1, 1, 1, 2, 3, 3, 3, 3, 4, 5, 5, 5, 5, 7, 8, 8, 7))")
println("Resultado obtenido: " + simplifica(List(1, 1, 1, 2, 3, 3, 3, 3, 4, 5, 5, 5, 5, 7, 8, 8, 7)))


























