# IONOS Coding challenge - Java
## Carlos Baeza - carlos.baeza@posteo.de

How to compile and run
> mvn clean package tomcat7:run -pl :challenger-ionos -am

then open you web browser or http client like Postman and request against: 
    
    http://localhost:8080/webapp/


Support for messages of type http POST with follow parameters

    - dataCenterId: any string
    - itemType: DATACENTER, SERVER, STORAGE
    - itemId: any string
    - attachToServerId: any string
    - attachToServerId: any string
    - action: CREATE, UPDATE, DELETE, MAKE_SNAPSHOT
    
## Example
    http://localhost:8080/webapp/?action=CREATE&dataCenterId=1&itemId=100&attachToServerId=999&itemType=DATACENTER
    

