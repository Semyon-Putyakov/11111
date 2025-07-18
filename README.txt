Demo Spring Boot Application
===========================

Описание:
----------
Это демонстрационное Spring Boot приложение на Java. Оно содержит базовый контроллер для работы с изображениями и шаблон для главной страницы.

Структура проекта:
------------------
- src/main/java/com/example/demo/         - исходный код приложения
  - DemoApplication.java                  - основной класс приложения
  - ImageController.java                  - контроллер для работы с изображениями
- src/main/resources/
  - application.properties                - настройки приложения
  - templates/index.html                  - шаблон главной страницы
- src/test/java/com/example/demo/         - тесты
- pom.xml                                 - зависимости Maven

Запуск приложения:
------------------
1. Убедитесь, что установлен JDK 17 или выше и Maven.
2. Откройте терминал в папке проекта.
3. Выполните команду:
   mvn spring-boot:run
4. Приложение будет доступно по адресу: http://localhost:8080

