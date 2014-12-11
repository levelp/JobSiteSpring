JobSiteSpring
=============

JobSite на основе Spring MVC 4

План урока:
===========
* Кодировка UTF-8
* Hibernate и БД PostgreSQL
* Страница ввода резюме и поиска по резюме

Настройки запуска:
------------------
* Run / Edit configurations... + Server Tomcat Local
* Deployment: + artifact

Настройка tomcat 
----------------
```xml
  <role rolename="manager-gui"/>
  <user username="admin" password="admin" roles="manager-gui"/>
```

Hibernate
---------
http://habrahabr.ru/post/29694/ - XML для каждого класса