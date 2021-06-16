import requests
import time
import random
from requests.exceptions import HTTPError
response = requests.get('http://localhost:8080/add?type=TEMP')
response2 = requests.get('http://localhost:8080/add?type=HUMI')
temp = response.text
humi = response2.text
print(temp)
print(humi)
while(1 > 0):
    data =  random.randint(0, 100)
    data2 =  random.randint(0, 100)
    print(data)
    print(data2)
    
    url1 = "http://localhost:8080/api?id=" + str(temp) + "&data=" + str(data)
    url2 = "http://localhost:8080/api?id=" + str(humi) + "&data=" + str(data2)
    resp = requests.get(url1)
    resp2 = requests.get(url2)
    time.sleep(10)
