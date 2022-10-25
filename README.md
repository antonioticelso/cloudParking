# CloudParking

## URL da API disponível

### Local
API: http://localhost:8080/parking

Documentation: http://localhost:8080/swagger-ui.html

### Produção
API: https://parking-cloud-mpca.herokuapp.com/

Documentation: https://parking-cloud-mpca.herokuapp.com/swagger-ui.html

### Run database

docker run --name parking-db -p 5432:5432 -e POSTEGRES_DB=parking -e POSTEGRES_USER=admin -e POSTEGRES_PASSWORD=admin -d postgres:10-alpine
