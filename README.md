# Dot-Test
Ini merupakan repository saya untuk menjawab test

saya membuat aplikasi sederhana yaitu pembuatan order pengiriman package
saya memberikan authentication sederhana dengan httpBasic

pertama yang harus dilakukan sebelum mengakses endpoint yang ada adalah signup dengan mengakses endpoint berikut :
POST /api/auth/signup
body : <br/>

  {<br/>
    "fullName":"nanda",<br/>
    "email":"nansamgr@gmail.coms",<br/>
    "password":"nanda0011",<br/>
    "phoneNumber":"0895330667787"<br/>
}<br/>


Dokumentasi api : 
GET /api/user -> mendapatkan seluruh data user.
GET /api/user/{id} -> mendapatkan detail user.
GET /api/order -> mendapatkan seluruh order.
GET /api/data/provinces -> mendapatkan seluruh data province

POST /api/order -> membuat order.
body  : <br/>
{ <br/>
    "packageWeight": 5,<br/>
    "courier": "JNT",<br/>
    "recipientName": "agus",<br/>
    "recipientNumber": "089999",<br/>
    "destinationId": "1",         ---> id dapat didapatkan melaui endpoint /api/data/provinces , lalu dapat dipilih salah satu province_idnya <br/>
    "originId" : "2"               ---> id dapat didapatkan melaui endpoint /api/data/provinces , lalu dapat dipilih salah satu province_idnya <br/>
}
