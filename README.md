# Code for cause 2013 for OSI Podgorica

## To run project execute command

- Setup database
```bash
docker run -p 3306:3306 -d --name osi-db-con \
--env MYSQL_USER=osi-user \
--env MYSQL_PASSWORD=secret \
--env MYSQL_ROOT_PASSWORD=root \
--env MYSQL_DATABASE=osi \
mysql:latest
```    

- On linux

```bash
./gradlew bootRun
```

- On windows

```bash
gradlew.bat bootRun
```
