# Практическая работа №5. Spring MVC

1. Установить PostgerSQL (с помощью командной строки):

   sudo apt-get update

   sudo apt-get install postgresql postgresql-contrib

2. Создать БД:

   sudo -i -u postgres

   psql

   CREATE DATABASE postgres WITH ENCODING 'UTF8';

3. Создать нового пользователя в соответствии с application.properties и дать права администратора:

   CREATE USER ademchenko WITH ENCRYPTED PASSWORD 'qwerty';

   GRANT ALL PRIVILEGES ON DATABASE postgres TO ademchenko;

5. Инициализировать БД:

   psql -U postgres -d postgres -f init.sql

6. Прописать в терминале mvn package

7. Перейти в созданную папку terminal

8. Собрать проект, прописав команду java -jar .\rkis-5-1.0-snapshot.jar
