# JAVA QA Sprint - 4

### запуск в Chrome

mvn test


### запуск с Firefox

mvn -Dbrowser=firefox test

Если mvn test падает с ошибкой 500, и не находит бинарник, то запускаем с параметром
bash
mvn -Dbrowser=firefox -Dwebdriver.firefox.bin="/Program Files/Mozilla Firefox/firefox.exe" test
