const xhr=new XMLHttpRequest();//creates an http request

xhr.addEventListener('load',()=>{
    console.log(xhr.response);//waiting 
});//we get a console of this url in console
//we put event listner on top then trigger the evnt
xhr.open('GET','https://supersimplebackend.dev');  //(type of http Message,where to send this http message(url))
xhr.send();
//xhr.response();//takes time for response to come so it is undefined as runs at 
//same time so give error
//we use addEventListner() so to have wait time

const xh=new XMLHttpRequest();
xh.addEventListener('load',()=>{
    console.log(xh.response);//waiting 
});
xh.open('GET','https://supersimplebackend.dev/hello');  //(type of http Message,where to send this http message(url))
xh.send();
//This is the URL path /hello outputs
//backend-practice.js:4 Hello! This is SuperSimpleDev's backend.

const x=new XMLHttpRequest();
x.addEventListener('load',()=>{
    console.log(x.response);//waiting 
});
x.open('GET','https://supersimplebackend.dev/products/first');  
x.send();
//gives 1st product
// output-{"id":"e43638ce-6aa0-4b85-b27f-e1d07eb678c6","image":"images/products/athletic-cotton-socks-6-pairs.jpg","name":"Black and Gray Athletic Cotton Socks - 6 Pairs","rating":{"stars":4.5,"count":87},"priceCents":1090,"keywords":["socks","sports","apparel"]}
//if we send not supporting url then error is there