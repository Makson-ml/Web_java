Задание №1



1\. После стирания типов "K" и "V" преобразуются в Object.



public class Pair {



&nbsp;   public Pair(Object key, Object value) {

&nbsp;       this.key = key;

&nbsp;       this.value = value;

&nbsp;   }



&nbsp;   public Object getKey() { return key; }

&nbsp;   public Object getValue() { return value; }



&nbsp;   public void setKey(Object key) { this.key = key; }

&nbsp;   public void setValue(Object value) { this.value = value; }



&nbsp;   private Object key;

&nbsp;   private Object value;

}



2\. После стирания типов метод преобразуется к следующему виду:



public static int findFirstGreaterThan(Comparable\[] at, Comparable elem) {

&nbsp;   // ...

}



Тип T заменяется на свою верхнюю границу Comparable.



3\. Решением является класс CoprimeFinder (FirstMutuallySimpleFinder). 

&nbsp;  Тесты находятся в main().

&nbsp;  

&nbsp;  Для поиска первого взаимно простого числа используется метод findFirst, 

&nbsp;  который принимает список чисел, границы диапазона и предикат UnaryPredicate.

&nbsp;  Предикат проверяет, что НОД числа со всеми числами из заданного списка равен 1.



Задание №2



retrieveLast возвращает null, если пост пустой.



2.1) Решением является класс SimplePost.

&nbsp;  Использует List<Attachment> без обобщённых типов.

&nbsp;  Методы: addItem(Attachment), getLastItem(), size()



2.2) Решением является класс GenericPost<E extends Attachment>.

&nbsp;  Использует обобщённый тип E.

&nbsp;  Методы: add(E), getLast(), count()

&nbsp;  Преимущество: типобезопасность на этапе компиляции, не требуются приведения типов.



Задание №3



Решением является класс SmartCopier (CopyManager).



Метод copyElements использует PECS (Producer Extends, Consumer Super):



public static <E> void copyElements(List<? super E> dest, List<? extends E> src)



\- src: List<? extends E> — производитель данных (только читаем)

\- dest: List<? super E> — потребитель данных (только записываем)



Это позволяет копировать элементы из списка подтипов в список супертипов.

Например: из List<Photo> в List<Attachment>.



Тесты находятся в main() каждого класса.

