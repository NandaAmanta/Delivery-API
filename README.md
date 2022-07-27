# Dot-Test
Ini merupakan repository saya untuk menjawab test

saya membuat aplikasi sederhana yaitu pembuatan order pengiriman package
saya memberikan authentication sederhana dengan httpBasic

pertama yang harus dilakukan sebelum mengakses endpoint yang ada adalah signup dengan mengakses endpoint berikut :
POST /api/auth/signup
body : 

  {
    "fullName":"nanda",
    "email":"nansamgr@gmail.coms",
    "password":"nanda0011",
    "phoneNumber":"0895330667787"
}


Dokumentasi api : 
GET /api/user -> mendapatkan seluruh data user.
GET /api/user/{id} -> mendapatkan detail user.
GET /api/order -> mendapatkan seluruh order.
GET /api/data/provinces -> mendapatkan seluruh data province

POST /api/order -> membuat order.
body  : 
{
    "packageWeight": 5,
    "courier": "JNT",
    "recipientName": "agus",
    "recipientNumber": "089999",
    "destinationId": "1",         ---> id dapat didapatkan melaui endpoint /api/data/provinces , lalu dapat dipilih salah satu province_idnya
    "originId" : "2"               ---> id dapat didapatkan melaui endpoint /api/data/provinces , lalu dapat dipilih salah satu province_idnya
}
