# IONOS Coding challenge - Java
## Carlos Baeza - carlos.baeza@posteo.de

## How to compile, execute junit tests and run
Runs the current project as a dynamic web application using an embedded Tomcat server.
> mvn clean package tomcat7:run

then send with a http client like Postman message to: 
    
    http://localhost:8080/webapp/

supported messages type:

    GET : to handler action "Take a Snapshot of storage"
    POST : to handler action "Create Server or Storage" and "Attach or Detach Storage to/from Server"
    PUT : to handler action "Update server or store"
    DELETE : to handler action "Delete Server, Storage or Datacenter"

Supported parameter values are:

    - dataCenterId: any string
    - itemType: DATACENTER, SERVER, STORAGE
    - itemId: any string
    - attachToServerId: any string
    - attachToServerId: any string
    - action: CREATE, UPDATE, ATTACH, DETACH, DELETE, TAKE_SNAPSHOT_OF_STORAGE
    
## Example with POST
    http://localhost:8080/webapp/?action=CREATE&dataCenterId=1&itemId=100&attachToServerId=999&itemType=DATACENTER
    
![Example using Postman](Example_post.png)
    
    
## Run integration test
> mvn clean verify -Pit
    
    

