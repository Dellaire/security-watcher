# Security Watcher

This project contains a client and a server component, which serve as a security camera controller. The client periodically creates images by using a connected camera and sends the data to the server. The server stores the image and labels it with a timestamp.

#### Testing

When navigating to the root of the project, the upload can be tested by calling:
```
curl -X POST -H "Content-Type: multipart/form-data" -F "image=@src/test/resources/test.jpeg" http://localhost:8080/images
```