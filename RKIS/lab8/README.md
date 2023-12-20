# Практическая работа №8. Spring JMS

1. Установить PostgerSQL (с помощью командной строки):

   sudo apt-get update

   sudo apt-get install postgresql postgresql-contrib

2. Инициализировать БД:

   psql -U postgres -d postgres -f init.sql

3. Прописать в терминале mvn package

4. Запустить сервер, перейдя в папку server и прописав в терминале java -jar target\server-1.0-snapshot.jar

5. Запустить клиента, перейдя в папку client и прописав в терминале java -jar target\client-1.0-snapshot.jar

## Команды Rest API

1. Чтобы получить все компьютеры, прописываем GET /apt/computer
2. Чтобы получить компьютер по id, прописываем GET /api/computer/{id}
3. Чтобы добавить новый компьютер, прописываем POST /api
4. Чтобы обновить информацию о компьютере, прописываем PUT /api/{id}
5. Чтобы удалить компьютер по id, прописываем DELETE /api/delete/{id}
