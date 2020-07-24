import requests, time

while True:
	files = {'image': ('src/test/resources/test.jpeg', open('test.jpeg', 'rb'))}
	response = requests.post('http://localhost:8080/images', files=files)
	time.sleep(1)