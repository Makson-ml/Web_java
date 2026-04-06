Thread vs Runnable
Thread — поток выполнения, Runnable — задача. Runnable предпочтительнее: разделяет логику и исполнение, позволяет использовать ExecutorService и наследовать другие классы.

Visibility / Atomicity / Ordering
Visibility: изменение в одном потоке может быть не видно другому (решение: volatile). Atomicity: составные операции могут прерываться (count++ не атомарно). Ordering: переупорядочивание инструкций может нарушить логику.

Happens-before
Отношение, гарантирующее видимость действий между потоками. Правила: (1) volatile write → volatile read; (2) unlock → lock того же монитора.

volatile
Гарантирует видимость и порядок, но не атомарность. volatile boolean stop работает как флаг, но volatile int count не спасает count++ от гонок.
synchronized и wait/notify
wait/notify требуют захвата монитора (synchronized). Условие проверяют в while, а не if, из-за спурных пробуждений и конкуренции потоков.