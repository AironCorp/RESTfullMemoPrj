# RESTfullMemoPrj

IDE: IntelliJ IDEA

JDK: Java 1.8

Application Server: GlassFish 5.0.0

Маршруты:

 1)Домашний:          http://localhost:8080/Memo/
 
   Пустой запрос(Get)
 
 2)Список заметок:    http://localhost:8080/Memo/get
 
   Пустой запрос(Get)
 
 3)Добавить заметку:  http://localhost:8080/Memo/post
 
       Запроса(Put):  {
                         “title”: “Текст заголовка”,
                          “text”: “Текст заметки”
                      }
 
 4)Обновить заметку:  http://localhost:8080/Memo/update
 
       Запрос(Post):  {
                         “id”: “0ab7c16f-f911-4c00-9b11-ebcc295faf6c”,
                         “title”: “Новый заголовок”,
                         “text”: “Новый текст”
                      }
 
 5)Удалить заметку:   http://localhost:8080/Memo/delete
 
    Запрос(Delete):   {
                         “id”: “0ab7c16f-f911-4c00-9b11-ebcc295faf6c”,
                      }
 
P.S.
Задание не законченно, не имел опыта ранее с работой в REST,
понимаю что запутался в JAX-RS Annotation,
ибо данные передоваеммые на контроллер при помощи запросов не доходят до аргументов функции,
убедился в процессе проб и ошибок.

P.S.S.
Если возможно исправить код, я был бы не против узнать в чем ошибки передачи параметров.
