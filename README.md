# Dot-Test
Ini merupakan repository saya untuk menjawab test<br/>

saya membuat aplikasi sederhana yaitu pembuatan order pengiriman package<br/>
saya memberikan authentication sederhana dengan httpBasic<br/>

pertama yang harus dilakukan sebelum mengakses endpoint yang ada adalah signup dengan mengakses endpoint berikut :<br/>
POST /api/auth/signup<br/>
body : <br/>

  {<br/>
    "fullName":"nanda",<br/>
    "email":"nansamgr@gmail.coms",<br/>
    "password":"nanda0011",<br/>
    "phoneNumber":"0895330667787"<br/>
}<br/>


Dokumentasi api : <br/>
GET /api/user -> mendapatkan seluruh data user.<br/>
GET /api/user/{id} -> mendapatkan detail user.<br/>
GET /api/order -> mendapatkan seluruh order.<br/>
GET /api/data/provinces -> mendapatkan seluruh data province<br/>

POST /api/order -> membuat order.<br/>
body  : <br/>
{ <br/>
    "packageWeight": 5,<br/>
    "courier": "JNT",<br/>
    "recipientName": "agus",<br/>
    "recipientNumber": "089999",<br/>
    "destinationId": "1",         ---> id dapat didapatkan melaui endpoint /api/data/provinces , lalu dapat dipilih salah satu province_idnya <br/>
    "originId" : "2"               ---> id dapat didapatkan melaui endpoint /api/data/provinces , lalu dapat dipilih salah satu province_idnya <br/>
}